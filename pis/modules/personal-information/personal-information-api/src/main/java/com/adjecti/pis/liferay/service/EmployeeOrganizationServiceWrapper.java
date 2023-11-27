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
 * Provides a wrapper for {@link EmployeeOrganizationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationService
 * @generated
 */
public class EmployeeOrganizationServiceWrapper
	implements EmployeeOrganizationService,
			   ServiceWrapper<EmployeeOrganizationService> {

	public EmployeeOrganizationServiceWrapper(
		EmployeeOrganizationService employeeOrganizationService) {

		_employeeOrganizationService = employeeOrganizationService;
	}

	@Override
	public boolean existsEmployeeOrganization(
		long employeeId, long organizationId) {

		return _employeeOrganizationService.existsEmployeeOrganization(
			employeeId, organizationId);
	}

	@Override
	public boolean existsEmployeeSubOrganization(
		long employeeId, long subOrganizationId) {

		return _employeeOrganizationService.existsEmployeeSubOrganization(
			employeeId, subOrganizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getByEmployeeIdAndOrganizationId(long employeeId, long organizationId) {

		return _employeeOrganizationService.getByEmployeeIdAndOrganizationId(
			employeeId, organizationId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getNonAssignedOrganizationsOfEmployee(
			long parentId, String type, long employeeId) {

		return _employeeOrganizationService.
			getNonAssignedOrganizationsOfEmployee(parentId, type, employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeOrganizationService.getOSGiServiceIdentifier();
	}

	@Override
	public String updateOrganization(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return _employeeOrganizationService.updateOrganization(
			themeDisplay, status, organizationId);
	}

	@Override
	public EmployeeOrganizationService getWrappedService() {
		return _employeeOrganizationService;
	}

	@Override
	public void setWrappedService(
		EmployeeOrganizationService employeeOrganizationService) {

		_employeeOrganizationService = employeeOrganizationService;
	}

	private EmployeeOrganizationService _employeeOrganizationService;

}