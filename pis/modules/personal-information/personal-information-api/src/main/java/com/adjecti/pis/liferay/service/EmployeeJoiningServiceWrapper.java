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
 * Provides a wrapper for {@link EmployeeJoiningService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeJoiningService
 * @generated
 */
public class EmployeeJoiningServiceWrapper
	implements EmployeeJoiningService, ServiceWrapper<EmployeeJoiningService> {

	public EmployeeJoiningServiceWrapper(
		EmployeeJoiningService employeeJoiningService) {

		_employeeJoiningService = employeeJoiningService;
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining
			addEmployeeJoiningDetails(
				com.adjecti.pis.liferay.model.EmployeeJoining employeeJoining)
		throws com.adjecti.pis.liferay.exception.EmployeeJoiningException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeJoiningService.addEmployeeJoiningDetails(
			employeeJoining);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		getByPersonalNo(String personalNo) {

		return _employeeJoiningService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		getJoiningByEmployeeId(long employeeId) {

		return _employeeJoiningService.getJoiningByEmployeeId(employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeJoiningService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeJoiningService getWrappedService() {
		return _employeeJoiningService;
	}

	@Override
	public void setWrappedService(
		EmployeeJoiningService employeeJoiningService) {

		_employeeJoiningService = employeeJoiningService;
	}

	private EmployeeJoiningService _employeeJoiningService;

}