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
 * Provides a wrapper for {@link EmployeeWorkstationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkstationService
 * @generated
 */
public class EmployeeWorkstationServiceWrapper
	implements EmployeeWorkstationService,
			   ServiceWrapper<EmployeeWorkstationService> {

	public EmployeeWorkstationServiceWrapper(
		EmployeeWorkstationService employeeWorkstationService) {

		_employeeWorkstationService = employeeWorkstationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkstation>
		getByEmployeeId(long employeeId) {

		return _employeeWorkstationService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkstation>
		getByPersonalNo(String personalNo) {

		return _employeeWorkstationService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeWorkstationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeWorkstationService getWrappedService() {
		return _employeeWorkstationService;
	}

	@Override
	public void setWrappedService(
		EmployeeWorkstationService employeeWorkstationService) {

		_employeeWorkstationService = employeeWorkstationService;
	}

	private EmployeeWorkstationService _employeeWorkstationService;

}