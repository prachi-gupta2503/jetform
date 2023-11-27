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
 * Provides a wrapper for {@link EmployeeDscService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDscService
 * @generated
 */
public class EmployeeDscServiceWrapper
	implements EmployeeDscService, ServiceWrapper<EmployeeDscService> {

	public EmployeeDscServiceWrapper(EmployeeDscService employeeDscService) {
		_employeeDscService = employeeDscService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDscService.getOSGiServiceIdentifier();
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc update(
		com.adjecti.pis.liferay.model.EmployeeDsc employeeDsc) {

		return _employeeDscService.update(employeeDsc);
	}

	@Override
	public EmployeeDscService getWrappedService() {
		return _employeeDscService;
	}

	@Override
	public void setWrappedService(EmployeeDscService employeeDscService) {
		_employeeDscService = employeeDscService;
	}

	private EmployeeDscService _employeeDscService;

}