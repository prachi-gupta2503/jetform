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
 * Provides a wrapper for {@link EmployeeAddressService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressService
 * @generated
 */
public class EmployeeAddressServiceWrapper
	implements EmployeeAddressService, ServiceWrapper<EmployeeAddressService> {

	public EmployeeAddressServiceWrapper(
		EmployeeAddressService employeeAddressService) {

		_employeeAddressService = employeeAddressService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getByPersonalNo(String personalNo) {

		return _employeeAddressService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getEmployeeAddressByEmployeeId(long employeeId) {

		return _employeeAddressService.getEmployeeAddressByEmployeeId(
			employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeAddressService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeAddressService getWrappedService() {
		return _employeeAddressService;
	}

	@Override
	public void setWrappedService(
		EmployeeAddressService employeeAddressService) {

		_employeeAddressService = employeeAddressService;
	}

	private EmployeeAddressService _employeeAddressService;

}