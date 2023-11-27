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
 * Provides a wrapper for {@link EmployeeGradeService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeGradeService
 * @generated
 */
public class EmployeeGradeServiceWrapper
	implements EmployeeGradeService, ServiceWrapper<EmployeeGradeService> {

	public EmployeeGradeServiceWrapper(
		EmployeeGradeService employeeGradeService) {

		_employeeGradeService = employeeGradeService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeGrade>
		getByEmployeeId(long employeeId) {

		return _employeeGradeService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeGrade>
		getByPersonalNo(String personalNo) {

		return _employeeGradeService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeGradeService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeGradeService getWrappedService() {
		return _employeeGradeService;
	}

	@Override
	public void setWrappedService(EmployeeGradeService employeeGradeService) {
		_employeeGradeService = employeeGradeService;
	}

	private EmployeeGradeService _employeeGradeService;

}