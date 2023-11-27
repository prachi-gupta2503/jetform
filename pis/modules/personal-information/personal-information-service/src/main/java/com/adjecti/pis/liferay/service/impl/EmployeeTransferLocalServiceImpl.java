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
import com.adjecti.pis.liferay.model.EmployeePromotion;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.service.base.EmployeeTransferLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee transfer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeTransferLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.",
	service = AopService.class
)
public class EmployeeTransferLocalServiceImpl
	extends EmployeeTransferLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeTransferLocalServiceImpl.class.getName());
	
	public List<EmployeeTransfer> getByEmployeeId(long employeeId)
	{
		return employeeTransferPersistence.findByEmployeeId(employeeId);
	}
	public List<EmployeeTransfer> getByPersonalNo(String personalNo)
	{
		try {
			Employee employee = employeePersistence.findByPersonalNo(personalNo);
				if(employee != null)
				{
					return employeeTransferPersistence.findByEmployeeId(employee.getEmployeeId());
				}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
	}
public List<EmployeeTransfer> getGradeModeByGradeModeId(long gradeModeId){
		
		return employeeTransferPersistence.findByGradeModeId(gradeModeId);
}
public List<EmployeeTransfer> getByToOrganizationId(long toOrganizationId)
{
	return employeeTransferPersistence.findByToOrganizationId(toOrganizationId);
}

public List<EmployeeTransfer> getByFromOrganizationId(long fromOrganizationId)
{
	return employeeTransferPersistence.findByFromOrganizationId(fromOrganizationId);
}



}