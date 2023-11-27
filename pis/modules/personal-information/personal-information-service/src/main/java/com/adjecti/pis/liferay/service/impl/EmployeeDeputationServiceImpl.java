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

package com.adjecti.pis.liferay.service.impl;

import com.adjecti.pis.liferay.model.EmployeeDeputation;
import com.adjecti.pis.liferay.service.base.EmployeeDeputationServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee deputation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeDeputationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=pis",
		"json.web.service.context.path=EmployeeDeputation"
	},
	service = AopService.class
)
public class EmployeeDeputationServiceImpl
	extends EmployeeDeputationServiceBaseImpl {

	public List<EmployeeDeputation> getByEmployeeId(long employeeId)
	{
		return employeeDeputationLocalService.getByEmployeeId(employeeId);
	}
	
	public List<EmployeeDeputation> getByPersonaNo(String personalNo)
	{
		return employeeDeputationLocalService.getByPersonaNo(personalNo);
	}
}