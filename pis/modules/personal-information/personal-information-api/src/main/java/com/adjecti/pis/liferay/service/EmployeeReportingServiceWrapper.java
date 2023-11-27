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
 * Provides a wrapper for {@link EmployeeReportingService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeReportingService
 * @generated
 */
public class EmployeeReportingServiceWrapper
	implements EmployeeReportingService,
			   ServiceWrapper<EmployeeReportingService> {

	public EmployeeReportingServiceWrapper(
		EmployeeReportingService employeeReportingService) {

		_employeeReportingService = employeeReportingService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByEmployeeId(
		long employeeId) {

		return _employeeReportingService.getByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByPersonalNo(
		String personalNo) {

		return _employeeReportingService.getByPersonalNo(personalNo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByReportingToId(
		long reportingToId) {

		return _employeeReportingService.getByReportingToId(reportingToId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeReportingService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeReportingService getWrappedService() {
		return _employeeReportingService;
	}

	@Override
	public void setWrappedService(
		EmployeeReportingService employeeReportingService) {

		_employeeReportingService = employeeReportingService;
	}

	private EmployeeReportingService _employeeReportingService;

}