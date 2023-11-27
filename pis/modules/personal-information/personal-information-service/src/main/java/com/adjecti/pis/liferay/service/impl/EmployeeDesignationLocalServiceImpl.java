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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationException;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeDesignation;
import com.adjecti.pis.liferay.service.base.EmployeeDesignationLocalServiceBaseImpl;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee designation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeDesignationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeDesignation", service = AopService.class)
public class EmployeeDesignationLocalServiceImpl extends EmployeeDesignationLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeDesignationLocalServiceImpl.class.getName());

	public List<EmployeeDesignation> getByEmployeeId(long employeeId) {
		return employeeDesignationPersistence.findByEmployeeId(employeeId);
	}

	public List<EmployeeDesignation> getByPersonalNo(String personalNo) {
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if (employee != null) {
				return employeeDesignationPersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;

	}
	
	public boolean updateByEmployeeId(long employeeId, long designationId) throws PortalException {
		Employee employee;
		Designation curDesignation=null;
		Designation newDesignation=null;
		try {
			employee = employeePersistence.findByEmployeeId(employeeId);
			if(employee.getDesignationId()>0) {
				curDesignation=DesignationLocalServiceUtil.getDesignation(employee.getDesignationId());
			}
			newDesignation=DesignationLocalServiceUtil.getDesignation(designationId);
			employee.setDesignationId(designationId);
			employeePersistence.update(employee);
		} catch (NoSuchEmployeeException e ) {
			_logger.error(e.getMessage());
			throw new PortalException(e);
		}catch(NoSuchDesignationException e) {
			_logger.error(e.getMessage());
			throw new PortalException(e);
		}
		
		try {
			PISUserUtil.updateIDAMUser(employee.getLoginId(), "designation", (curDesignation!=null?curDesignation.getName_En():""), (newDesignation!=null?newDesignation.getName_En():""));
		} catch (Exception e) {
			_logger.error(e.getMessage());
			throw new PortalException(new Exception("Employee was updated, but IDAM updatation failed",e));
		}
		return true;

	}

}