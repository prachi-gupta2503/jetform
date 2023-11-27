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
import com.adjecti.pis.liferay.model.EmployeeWorkArea;
import com.adjecti.pis.liferay.service.base.EmployeeWorkAreaLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee work area local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeWorkAreaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkAreaLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeWorkArea",
	service = AopService.class
)
public class EmployeeWorkAreaLocalServiceImpl
	extends EmployeeWorkAreaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.pis.liferay.service.EmployeeWorkAreaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.pis.liferay.service.EmployeeWorkAreaLocalServiceUtil</code>.
	 */
	private final static Log _logger = LogFactoryUtil.getLog(EmployeeWorkAreaLocalServiceImpl.class.getName());
	
	public List<EmployeeWorkArea> getByEmployeeId(long employeeId) {
		return employeeWorkAreaPersistence.findByEmployeeId(employeeId);
	}
	
	public List<EmployeeWorkArea> findByWorkAreaId(long workAreaId) {
		return employeeWorkAreaPersistence.findByWorkAreaMajorId(workAreaId);
	}

	public List<EmployeeWorkArea> getByPersonalNo(String personalNo) {
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if (employee != null) {
				return employeeWorkAreaPersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;

	}
}