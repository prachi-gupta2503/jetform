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
 * Provides a wrapper for {@link EmployeeExperienceService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceService
 * @generated
 */
public class EmployeeExperienceServiceWrapper
	implements EmployeeExperienceService,
			   ServiceWrapper<EmployeeExperienceService> {

	public EmployeeExperienceServiceWrapper(
		EmployeeExperienceService employeeExperienceService) {

		_employeeExperienceService = employeeExperienceService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getByEmployeeId(long employeeId) {

		return _employeeExperienceService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getByPersonalNo(String personalNo) {

		return _employeeExperienceService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeExperienceService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeExperienceService getWrappedService() {
		return _employeeExperienceService;
	}

	@Override
	public void setWrappedService(
		EmployeeExperienceService employeeExperienceService) {

		_employeeExperienceService = employeeExperienceService;
	}

	private EmployeeExperienceService _employeeExperienceService;

}