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
 * Provides a wrapper for {@link EmployeeBiodataService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBiodataService
 * @generated
 */
public class EmployeeBiodataServiceWrapper
	implements EmployeeBiodataService, ServiceWrapper<EmployeeBiodataService> {

	public EmployeeBiodataServiceWrapper(
		EmployeeBiodataService employeeBiodataService) {

		_employeeBiodataService = employeeBiodataService;
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata
		getEmployeeBiodataByEmployeeId(long employeeId) {

		return _employeeBiodataService.getEmployeeBiodataByEmployeeId(
			employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeBiodataService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeBiodataService getWrappedService() {
		return _employeeBiodataService;
	}

	@Override
	public void setWrappedService(
		EmployeeBiodataService employeeBiodataService) {

		_employeeBiodataService = employeeBiodataService;
	}

	private EmployeeBiodataService _employeeBiodataService;

}