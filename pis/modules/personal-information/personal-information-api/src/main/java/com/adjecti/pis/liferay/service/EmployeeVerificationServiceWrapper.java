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
 * Provides a wrapper for {@link EmployeeVerificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeVerificationService
 * @generated
 */
public class EmployeeVerificationServiceWrapper
	implements EmployeeVerificationService,
			   ServiceWrapper<EmployeeVerificationService> {

	public EmployeeVerificationServiceWrapper(
		EmployeeVerificationService employeeVerificationService) {

		_employeeVerificationService = employeeVerificationService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
			addEmployeeVerifications(
				java.util.List
					<com.adjecti.pis.liferay.model.EmployeeVerification>
						employeeVerifications)
		throws com.adjecti.pis.liferay.exception.EmployeeAddressException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeVerificationService.addEmployeeVerifications(
			employeeVerifications);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
		getByPersonalNo(String personalNo) {

		return _employeeVerificationService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
		getEmployeeVerificationByEmployeeId(long employeeId) {

		return _employeeVerificationService.getEmployeeVerificationByEmployeeId(
			employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeVerificationService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeVerificationService getWrappedService() {
		return _employeeVerificationService;
	}

	@Override
	public void setWrappedService(
		EmployeeVerificationService employeeVerificationService) {

		_employeeVerificationService = employeeVerificationService;
	}

	private EmployeeVerificationService _employeeVerificationService;

}