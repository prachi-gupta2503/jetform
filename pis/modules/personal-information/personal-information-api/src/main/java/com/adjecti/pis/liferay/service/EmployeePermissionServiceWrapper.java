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
 * Provides a wrapper for {@link EmployeePermissionService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePermissionService
 * @generated
 */
public class EmployeePermissionServiceWrapper
	implements EmployeePermissionService,
			   ServiceWrapper<EmployeePermissionService> {

	public EmployeePermissionServiceWrapper(
		EmployeePermissionService employeePermissionService) {

		_employeePermissionService = employeePermissionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePermissionService.getOSGiServiceIdentifier();
	}

	@Override
	public Object updatePermission(
			long employeePermissionId, boolean emailAccess,
			boolean digitalSigning, boolean eGovAccess, boolean pisAccess)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePermissionService.updatePermission(
			employeePermissionId, emailAccess, digitalSigning, eGovAccess,
			pisAccess);
	}

	@Override
	public EmployeePermissionService getWrappedService() {
		return _employeePermissionService;
	}

	@Override
	public void setWrappedService(
		EmployeePermissionService employeePermissionService) {

		_employeePermissionService = employeePermissionService;
	}

	private EmployeePermissionService _employeePermissionService;

}