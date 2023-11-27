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
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.EmployeeConfirmation;
import com.adjecti.pis.liferay.service.base.EmployeeConfirmationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee confirmation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeConfirmationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeConfirmation",
	service = AopService.class
)
public class EmployeeConfirmationLocalServiceImpl
	extends EmployeeConfirmationLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeConfirmationLocalServiceImpl.class.getName());
	
	public List<EmployeeConfirmation> getByEmployeeId(long employeeId)
	{
		return employeeConfirmationPersistence.findByEmployeeId(employeeId);
	}
	
	public List<EmployeeConfirmation> getByPersonalNo(String personalNo)
	{
		try {
			Employee employee = employeePersistence.findByPersonalNo(personalNo);
			if(employee != null)
			{
				employeeConfirmationPersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
		
	}
	
public List<EmployeeConfirmation> getGradeModeByGradeModeId(long gradeModeId){
		
		return employeeConfirmationPersistence.findByGradeModeId(gradeModeId);
}
	
public List<EmployeeConfirmation> getByOrganizationId(long organizationId){
	
	return employeeConfirmationPersistence.findByOrganizationId(organizationId);
}	

}