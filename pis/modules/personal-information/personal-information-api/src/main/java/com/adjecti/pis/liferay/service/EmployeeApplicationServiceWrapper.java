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
 * Provides a wrapper for {@link EmployeeApplicationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeApplicationService
 * @generated
 */
public class EmployeeApplicationServiceWrapper
	implements EmployeeApplicationService,
			   ServiceWrapper<EmployeeApplicationService> {

	public EmployeeApplicationServiceWrapper(
		EmployeeApplicationService employeeApplicationService) {

		_employeeApplicationService = employeeApplicationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeApplication>
			addEmployeeApplications(
				java.util.List
					<com.adjecti.pis.liferay.model.EmployeeApplication>
						employeeApplications)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeApplicationService.addEmployeeApplications(
			employeeApplications);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeApplication>
		getByEmployeeId(long employeeId) {

		return _employeeApplicationService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeApplication>
		getByPersonaNo(String personalNo) {

		return _employeeApplicationService.getByPersonaNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeApplicationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeApplicationService getWrappedService() {
		return _employeeApplicationService;
	}

	@Override
	public void setWrappedService(
		EmployeeApplicationService employeeApplicationService) {

		_employeeApplicationService = employeeApplicationService;
	}

	private EmployeeApplicationService _employeeApplicationService;

}