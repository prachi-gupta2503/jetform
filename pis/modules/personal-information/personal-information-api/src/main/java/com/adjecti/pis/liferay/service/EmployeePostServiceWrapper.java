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
 * Provides a wrapper for {@link EmployeePostService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePostService
 * @generated
 */
public class EmployeePostServiceWrapper
	implements EmployeePostService, ServiceWrapper<EmployeePostService> {

	public EmployeePostServiceWrapper(EmployeePostService employeePostService) {
		_employeePostService = employeePostService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByEmployeeId(
		long employeeId) {

		return _employeePostService.getByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByPersonalNo(
		String personalNo) {

		return _employeePostService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePostService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeePostService getWrappedService() {
		return _employeePostService;
	}

	@Override
	public void setWrappedService(EmployeePostService employeePostService) {
		_employeePostService = employeePostService;
	}

	private EmployeePostService _employeePostService;

}