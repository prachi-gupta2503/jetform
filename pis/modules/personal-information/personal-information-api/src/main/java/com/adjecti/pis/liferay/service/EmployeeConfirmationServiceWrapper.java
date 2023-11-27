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
 * Provides a wrapper for {@link EmployeeConfirmationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmationService
 * @generated
 */
public class EmployeeConfirmationServiceWrapper
	implements EmployeeConfirmationService,
			   ServiceWrapper<EmployeeConfirmationService> {

	public EmployeeConfirmationServiceWrapper(
		EmployeeConfirmationService employeeConfirmationService) {

		_employeeConfirmationService = employeeConfirmationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeConfirmation>
		getByEmployeeId(long employeeId) {

		return _employeeConfirmationService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeConfirmation>
		getByPersonalNo(String personalNo) {

		return _employeeConfirmationService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeConfirmationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeConfirmationService getWrappedService() {
		return _employeeConfirmationService;
	}

	@Override
	public void setWrappedService(
		EmployeeConfirmationService employeeConfirmationService) {

		_employeeConfirmationService = employeeConfirmationService;
	}

	private EmployeeConfirmationService _employeeConfirmationService;

}