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

import com.adjecti.pis.liferay.model.EmployeeSavingScheme;
import com.adjecti.pis.liferay.service.base.EmployeeSavingSchemeServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee saving scheme remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeSavingSchemeService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSavingSchemeServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=pis",
		"json.web.service.context.path=EmployeeSavingScheme" }, service = AopService.class)
public class EmployeeSavingSchemeServiceImpl extends EmployeeSavingSchemeServiceBaseImpl {

	public List<EmployeeSavingScheme> getByEmployeeId(long employeeId) {
		return employeeSavingSchemeLocalService.getByEmployeeId(employeeId);
	}

	public List<EmployeeSavingScheme> getByPersonalNo(String personalNo) {
		return employeeSavingSchemeLocalService.getByPersonalNo(personalNo);
	}
}