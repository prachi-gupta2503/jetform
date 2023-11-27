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
 * Provides a wrapper for {@link EmployeeEmailService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEmailService
 * @generated
 */
public class EmployeeEmailServiceWrapper
	implements EmployeeEmailService, ServiceWrapper<EmployeeEmailService> {

	public EmployeeEmailServiceWrapper(
		EmployeeEmailService employeeEmailService) {

		_employeeEmailService = employeeEmailService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeEmailService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeEmailService getWrappedService() {
		return _employeeEmailService;
	}

	@Override
	public void setWrappedService(EmployeeEmailService employeeEmailService) {
		_employeeEmailService = employeeEmailService;
	}

	private EmployeeEmailService _employeeEmailService;

}