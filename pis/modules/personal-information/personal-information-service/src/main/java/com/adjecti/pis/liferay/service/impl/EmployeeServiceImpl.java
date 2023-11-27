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
import com.adjecti.pis.liferay.service.base.EmployeeServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=pis",
		"json.web.service.context.path=Employee" }, service = AopService.class)
public class EmployeeServiceImpl extends EmployeeServiceBaseImpl {
	public Employee getEmployeeByEmployeeId(long employeeId) throws NoSuchEmployeeException {
		try {
			return employeeLocalService.getEmployeeByEmployeeId(employeeId);
		} catch (NoSuchEmployeeException e) {
			throw new NoSuchEmployeeException("Invalid: " + employeeId);
		}
	}
	@AccessControlled(guestAccessEnabled = true)
	public JSONObject getEmployeeByPersonalNo(String personalNo) throws NoSuchEmployeeException {
		try {
			Employee employee= employeeLocalService.getEmployeeByPersonalNo(personalNo);
			return employeeLocalService.entityToJson(employee);
		} catch (Exception e) {
			throw new NoSuchEmployeeException("Invalid: " + personalNo);
		}
	}

	public void submitEmployeeJoining(long employeeId) {
		try {
			employeeLocalService.submitEmployeeJoining(employeeId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}

	public void performWorkFlowAction(long employeeId, String action) throws PortalException {
		employeeLocalService.performWorkFlowAction(employeeId, action);
	}

	public JSONArray getEmployeeBySearchFilter(long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroupId,long cadreId, String keywords) throws PortalException {
		return employeeLocalService.getEmployeeBySearchFilter(organizationId, tradeId, gradeId, designationId,
				designationGroupId,cadreId, keywords);
	}
	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getEmployees() throws PortalException {
		return employeeLocalService.getEmployees();
	}

	public JSONArray getByTradeName(String tradeName) throws PortalException {
		return employeeLocalService.getByTradeName(tradeName);
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getByGradeName(String gradeName) throws PortalException {
		return employeeLocalService.getByGradeName(gradeName);
	}

	public JSONArray getEmployeeList() throws PortalException {
		return employeeLocalService.getEmployeeList();
	}

	public JSONArray getEmployeesByKeywords(long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroupId, String keywords) throws PortalException {
		return employeeLocalService.getEmployeesByKeywords(organizationId, tradeId, gradeId, designationId,
				designationGroupId, keywords);
	}

//	public void deleteAllData() throws PortalException {
//		employeeLocalService.deleteAllData();
//	}
	public List<Organization> getUserUnit(){
		return employeeLocalService.getUserUnit();
	}
	
	public void deleteByEmployeeId(long employeeId) throws PortalException {
		employeeLocalService.deleteByEmployeeId(employeeId);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public List<Employee> searchEmployees(Map<String, String> searchFilter){
		return employeeLocalService.searchEmployees(searchFilter);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	public boolean isUnique(long employeeId, Map<String, String> fieldValues) {
		return employeeLocalService.isUnique(employeeId, fieldValues);
	}
	
	public void initEmployeesList() {
		employeeLocalService.initEmployeesList();
	}
	
	
}
