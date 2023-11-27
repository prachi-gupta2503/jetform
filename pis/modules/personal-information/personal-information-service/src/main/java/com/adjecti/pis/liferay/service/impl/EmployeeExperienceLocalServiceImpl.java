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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.adjecti.pis.liferay.service.base.EmployeeExperienceLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee experience local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeExperienceLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeExperience", service = AopService.class)
public class EmployeeExperienceLocalServiceImpl extends EmployeeExperienceLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeExperienceLocalServiceImpl.class.getName());

	public List<EmployeeExperience> getByEmployeeId(long employeeId) {
		return employeeExperiencePersistence.findByEmployeeId(employeeId);
	}

	public List<EmployeeExperience> getByPersonalNo(String personalNo) {
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if (employee != null) {
				return employeeExperiencePersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;

	}
	public List<EmployeeExperience> getByUnitId(long organizationId) {
		return employeeExperiencePersistence.findByOrganizationId(organizationId);
	}
	
	public List<EmployeeExperience> getByWorkAreaMajorId(long workAreaMajorId) {
		return employeeExperiencePersistence.findByWorkAreaId(workAreaMajorId);
	}
	
	public List<EmployeeExperience> getByWorkAreaMinorId(long workAreaMinorId) {
		return employeeExperiencePersistence.findByWorkAreaMinorId(workAreaMinorId);
	}

	

	
	
}