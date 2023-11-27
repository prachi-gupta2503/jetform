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
 * Provides a wrapper for {@link EmployeeTransferRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferRequestService
 * @generated
 */
public class EmployeeTransferRequestServiceWrapper
	implements EmployeeTransferRequestService,
			   ServiceWrapper<EmployeeTransferRequestService> {

	public EmployeeTransferRequestServiceWrapper(
		EmployeeTransferRequestService employeeTransferRequestService) {

		_employeeTransferRequestService = employeeTransferRequestService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeTransferRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeTransferRequestService getWrappedService() {
		return _employeeTransferRequestService;
	}

	@Override
	public void setWrappedService(
		EmployeeTransferRequestService employeeTransferRequestService) {

		_employeeTransferRequestService = employeeTransferRequestService;
	}

	private EmployeeTransferRequestService _employeeTransferRequestService;

}