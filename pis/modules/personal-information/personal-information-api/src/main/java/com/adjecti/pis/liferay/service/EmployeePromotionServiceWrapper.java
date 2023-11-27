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
 * Provides a wrapper for {@link EmployeePromotionService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotionService
 * @generated
 */
public class EmployeePromotionServiceWrapper
	implements EmployeePromotionService,
			   ServiceWrapper<EmployeePromotionService> {

	public EmployeePromotionServiceWrapper(
		EmployeePromotionService employeePromotionService) {

		_employeePromotionService = employeePromotionService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePromotion>
		getByEmployeeId(long employeeId) {

		return _employeePromotionService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePromotion>
		getByPersonalNo(String personalNo) {

		return _employeePromotionService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePromotionService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeePromotionService getWrappedService() {
		return _employeePromotionService;
	}

	@Override
	public void setWrappedService(
		EmployeePromotionService employeePromotionService) {

		_employeePromotionService = employeePromotionService;
	}

	private EmployeePromotionService _employeePromotionService;

}