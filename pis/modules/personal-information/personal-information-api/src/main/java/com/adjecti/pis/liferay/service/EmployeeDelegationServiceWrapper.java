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
 * Provides a wrapper for {@link EmployeeDelegationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDelegationService
 * @generated
 */
public class EmployeeDelegationServiceWrapper
	implements EmployeeDelegationService,
			   ServiceWrapper<EmployeeDelegationService> {

	public EmployeeDelegationServiceWrapper(
		EmployeeDelegationService employeeDelegationService) {

		_employeeDelegationService = employeeDelegationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDelegation>
		getByEmployeeId(long employeeId) {

		return _employeeDelegationService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDelegation>
			getByPersonalNo(String personalNo)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDelegationException,
			   com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return _employeeDelegationService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDelegationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeDelegationService getWrappedService() {
		return _employeeDelegationService;
	}

	@Override
	public void setWrappedService(
		EmployeeDelegationService employeeDelegationService) {

		_employeeDelegationService = employeeDelegationService;
	}

	private EmployeeDelegationService _employeeDelegationService;

}