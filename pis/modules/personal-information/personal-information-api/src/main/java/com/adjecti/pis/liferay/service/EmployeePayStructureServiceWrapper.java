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
 * Provides a wrapper for {@link EmployeePayStructureService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePayStructureService
 * @generated
 */
public class EmployeePayStructureServiceWrapper
	implements EmployeePayStructureService,
			   ServiceWrapper<EmployeePayStructureService> {

	public EmployeePayStructureServiceWrapper(
		EmployeePayStructureService employeePayStructureService) {

		_employeePayStructureService = employeePayStructureService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePayStructure>
		getByEmployeeId(long employeeId) {

		return _employeePayStructureService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePayStructure>
		getByPersonalNo(String personalNo) {

		return _employeePayStructureService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePayStructureService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeePayStructureService getWrappedService() {
		return _employeePayStructureService;
	}

	@Override
	public void setWrappedService(
		EmployeePayStructureService employeePayStructureService) {

		_employeePayStructureService = employeePayStructureService;
	}

	private EmployeePayStructureService _employeePayStructureService;

}