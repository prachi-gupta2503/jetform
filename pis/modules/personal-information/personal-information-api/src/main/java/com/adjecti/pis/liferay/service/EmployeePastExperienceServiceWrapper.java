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
 * Provides a wrapper for {@link EmployeePastExperienceService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePastExperienceService
 * @generated
 */
public class EmployeePastExperienceServiceWrapper
	implements EmployeePastExperienceService,
			   ServiceWrapper<EmployeePastExperienceService> {

	public EmployeePastExperienceServiceWrapper(
		EmployeePastExperienceService employeePastExperienceService) {

		_employeePastExperienceService = employeePastExperienceService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
			addPastExperiences(
				java.util.List
					<com.adjecti.pis.liferay.model.EmployeePastExperience>
						employeeExperiences)
		throws com.adjecti.pis.liferay.exception.
			EmployeePastExperienceException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeePastExperienceService.addPastExperiences(
			employeeExperiences);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
		getByEmployeeId(long employeeId) {

		return _employeePastExperienceService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
		getByPersonalNo(String personalNo) {

		return _employeePastExperienceService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePastExperienceService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeePastExperienceService getWrappedService() {
		return _employeePastExperienceService;
	}

	@Override
	public void setWrappedService(
		EmployeePastExperienceService employeePastExperienceService) {

		_employeePastExperienceService = employeePastExperienceService;
	}

	private EmployeePastExperienceService _employeePastExperienceService;

}