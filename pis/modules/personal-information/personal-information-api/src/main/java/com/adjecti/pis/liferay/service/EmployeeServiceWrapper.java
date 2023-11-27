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
 * Provides a wrapper for {@link EmployeeService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeService
 * @generated
 */
public class EmployeeServiceWrapper
	implements EmployeeService, ServiceWrapper<EmployeeService> {

	public EmployeeServiceWrapper(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	@Override
	public void deleteByEmployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeService.deleteByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByGradeName(
			String gradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeService.getByGradeName(gradeName);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getByTradeName(
			String tradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeService.getByTradeName(tradeName);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee getEmployeeByEmployeeId(
			long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return _employeeService.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEmployeeByPersonalNo(
			String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return _employeeService.getEmployeeByPersonalNo(personalNo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployeeBySearchFilter(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroupId, long cadreId, String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeService.getEmployeeBySearchFilter(
			organizationId, tradeId, gradeId, designationId, designationGroupId,
			cadreId, keywords);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployeeList()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeService.getEmployeeList();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployees()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeService.getEmployees();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEmployeesByKeywords(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroupId, String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeService.getEmployeesByKeywords(
			organizationId, tradeId, gradeId, designationId, designationGroupId,
			keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getUserUnit() {

		return _employeeService.getUserUnit();
	}

	@Override
	public void initEmployeesList() {
		_employeeService.initEmployeesList();
	}

	@Override
	public boolean isUnique(
		long employeeId, java.util.Map<String, String> fieldValues) {

		return _employeeService.isUnique(employeeId, fieldValues);
	}

	@Override
	public void performWorkFlowAction(long employeeId, String action)
		throws com.liferay.portal.kernel.exception.PortalException {

		_employeeService.performWorkFlowAction(employeeId, action);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployees(java.util.Map<String, String> searchFilter) {

		return _employeeService.searchEmployees(searchFilter);
	}

	@Override
	public void submitEmployeeJoining(long employeeId) {
		_employeeService.submitEmployeeJoining(employeeId);
	}

	@Override
	public EmployeeService getWrappedService() {
		return _employeeService;
	}

	@Override
	public void setWrappedService(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	private EmployeeService _employeeService;

}