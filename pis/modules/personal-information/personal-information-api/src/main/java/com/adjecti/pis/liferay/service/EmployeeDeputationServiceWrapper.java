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
 * Provides a wrapper for {@link EmployeeDeputationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationService
 * @generated
 */
public class EmployeeDeputationServiceWrapper
	implements EmployeeDeputationService,
			   ServiceWrapper<EmployeeDeputationService> {

	public EmployeeDeputationServiceWrapper(
		EmployeeDeputationService employeeDeputationService) {

		_employeeDeputationService = employeeDeputationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDeputation>
		getByEmployeeId(long employeeId) {

		return _employeeDeputationService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDeputation>
		getByPersonaNo(String personalNo) {

		return _employeeDeputationService.getByPersonaNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDeputationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeDeputationService getWrappedService() {
		return _employeeDeputationService;
	}

	@Override
	public void setWrappedService(
		EmployeeDeputationService employeeDeputationService) {

		_employeeDeputationService = employeeDeputationService;
	}

	private EmployeeDeputationService _employeeDeputationService;

}