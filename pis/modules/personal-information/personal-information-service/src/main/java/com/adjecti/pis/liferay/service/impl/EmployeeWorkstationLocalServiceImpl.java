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
import com.adjecti.pis.liferay.model.EmployeeWorkstation;
import com.adjecti.pis.liferay.service.base.EmployeeWorkstationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee workstation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeWorkstationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkstationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeWorkstation",
	service = AopService.class
)
public class EmployeeWorkstationLocalServiceImpl
	extends EmployeeWorkstationLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeWorkstationLocalServiceImpl.class.getName());
	
	public List<EmployeeWorkstation> getByEmployeeId(long employeeId)
	{
		return employeeWorkstationPersistence.findByEmployeeId(employeeId);
	}
	
	public List<EmployeeWorkstation> getByPersonalNo(String personalNo)
	{
		try {
			Employee employee = employeePersistence.findByPersonalNo(personalNo);
				if(employee != null)
				{
					return employeeWorkstationPersistence.findByEmployeeId(employee.getEmployeeId());
				}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
	}
}