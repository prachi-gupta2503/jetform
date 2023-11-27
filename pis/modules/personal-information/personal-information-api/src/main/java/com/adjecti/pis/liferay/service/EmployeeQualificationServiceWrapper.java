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
 * Provides a wrapper for {@link EmployeeQualificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualificationService
 * @generated
 */
public class EmployeeQualificationServiceWrapper
	implements EmployeeQualificationService,
			   ServiceWrapper<EmployeeQualificationService> {

	public EmployeeQualificationServiceWrapper(
		EmployeeQualificationService employeeQualificationService) {

		_employeeQualificationService = employeeQualificationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
			addEmployeeQualification(
				java.util.List
					<com.adjecti.pis.liferay.model.EmployeeQualification>
						employeeQualification)
		throws com.adjecti.pis.liferay.exception.EmployeeQualificationException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeQualificationService.addEmployeeQualification(
			employeeQualification);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
		getByPersonalNo(String personalNo) {

		return _employeeQualificationService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeQualificationService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
		getQualificationByEmployeeId(long employeeId) {

		return _employeeQualificationService.getQualificationByEmployeeId(
			employeeId);
	}

	@Override
	public EmployeeQualificationService getWrappedService() {
		return _employeeQualificationService;
	}

	@Override
	public void setWrappedService(
		EmployeeQualificationService employeeQualificationService) {

		_employeeQualificationService = employeeQualificationService;
	}

	private EmployeeQualificationService _employeeQualificationService;

}