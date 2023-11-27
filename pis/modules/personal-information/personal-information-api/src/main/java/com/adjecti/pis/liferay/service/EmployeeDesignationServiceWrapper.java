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
 * Provides a wrapper for {@link EmployeeDesignationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationService
 * @generated
 */
public class EmployeeDesignationServiceWrapper
	implements EmployeeDesignationService,
			   ServiceWrapper<EmployeeDesignationService> {

	public EmployeeDesignationServiceWrapper(
		EmployeeDesignationService employeeDesignationService) {

		_employeeDesignationService = employeeDesignationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDesignation>
		getByEmployeeId(long employeeId) {

		return _employeeDesignationService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDesignation>
		getByPersonalNo(String personalNo) {

		return _employeeDesignationService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDesignationService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean updateByEmployeeId(long employeeId, long designationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationService.updateByEmployeeId(
			employeeId, designationId);
	}

	@Override
	public EmployeeDesignationService getWrappedService() {
		return _employeeDesignationService;
	}

	@Override
	public void setWrappedService(
		EmployeeDesignationService employeeDesignationService) {

		_employeeDesignationService = employeeDesignationService;
	}

	private EmployeeDesignationService _employeeDesignationService;

}