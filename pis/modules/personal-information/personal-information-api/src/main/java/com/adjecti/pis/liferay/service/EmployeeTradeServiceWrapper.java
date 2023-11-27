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
 * Provides a wrapper for {@link EmployeeTradeService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTradeService
 * @generated
 */
public class EmployeeTradeServiceWrapper
	implements EmployeeTradeService, ServiceWrapper<EmployeeTradeService> {

	public EmployeeTradeServiceWrapper(
		EmployeeTradeService employeeTradeService) {

		_employeeTradeService = employeeTradeService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTrade>
		getByEmployeeId(long employeeId) {

		return _employeeTradeService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTrade>
		getByPersonalNo(String personalNo) {

		return _employeeTradeService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeTradeService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeTradeService getWrappedService() {
		return _employeeTradeService;
	}

	@Override
	public void setWrappedService(EmployeeTradeService employeeTradeService) {
		_employeeTradeService = employeeTradeService;
	}

	private EmployeeTradeService _employeeTradeService;

}