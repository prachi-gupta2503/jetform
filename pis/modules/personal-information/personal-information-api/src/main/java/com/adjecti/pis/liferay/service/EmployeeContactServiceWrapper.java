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
 * Provides a wrapper for {@link EmployeeContactService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactService
 * @generated
 */
public class EmployeeContactServiceWrapper
	implements EmployeeContactService, ServiceWrapper<EmployeeContactService> {

	public EmployeeContactServiceWrapper(
		EmployeeContactService employeeContactService) {

		_employeeContactService = employeeContactService;
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact getByPersonalNo(
		String personalNo) {

		return _employeeContactService.getByPersonalNo(personalNo);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeContact
			getEmployeeContactByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return _employeeContactService.getEmployeeContactByEmployeeId(
			employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeContact>
			getEmployeeContactsByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return _employeeContactService.getEmployeeContactsByEmployeeId(
			employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeContactService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeContactService getWrappedService() {
		return _employeeContactService;
	}

	@Override
	public void setWrappedService(
		EmployeeContactService employeeContactService) {

		_employeeContactService = employeeContactService;
	}

	private EmployeeContactService _employeeContactService;

}