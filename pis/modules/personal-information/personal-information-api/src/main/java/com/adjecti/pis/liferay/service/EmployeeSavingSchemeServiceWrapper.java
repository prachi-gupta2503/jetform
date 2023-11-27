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
 * Provides a wrapper for {@link EmployeeSavingSchemeService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSavingSchemeService
 * @generated
 */
public class EmployeeSavingSchemeServiceWrapper
	implements EmployeeSavingSchemeService,
			   ServiceWrapper<EmployeeSavingSchemeService> {

	public EmployeeSavingSchemeServiceWrapper(
		EmployeeSavingSchemeService employeeSavingSchemeService) {

		_employeeSavingSchemeService = employeeSavingSchemeService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeSavingScheme>
		getByEmployeeId(long employeeId) {

		return _employeeSavingSchemeService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeSavingScheme>
		getByPersonalNo(String personalNo) {

		return _employeeSavingSchemeService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeSavingSchemeService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeSavingSchemeService getWrappedService() {
		return _employeeSavingSchemeService;
	}

	@Override
	public void setWrappedService(
		EmployeeSavingSchemeService employeeSavingSchemeService) {

		_employeeSavingSchemeService = employeeSavingSchemeService;
	}

	private EmployeeSavingSchemeService _employeeSavingSchemeService;

}