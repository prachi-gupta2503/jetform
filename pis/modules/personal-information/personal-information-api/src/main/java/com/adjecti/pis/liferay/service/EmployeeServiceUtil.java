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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Employee. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeService
 * @generated
 */
public class EmployeeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void deleteByEmployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteByEmployeeId(employeeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getByGradeName(
			String gradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByGradeName(gradeName);
	}

	public static com.liferay.portal.kernel.json.JSONArray getByTradeName(
			String tradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getByTradeName(tradeName);
	}

	public static com.adjecti.pis.liferay.model.Employee
			getEmployeeByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getService().getEmployeeByEmployeeId(employeeId);
	}

	public static com.liferay.portal.kernel.json.JSONObject
			getEmployeeByPersonalNo(String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getService().getEmployeeByPersonalNo(personalNo);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getEmployeeBySearchFilter(
				long organizationId, long tradeId, long gradeId,
				long designationId, long designationGroupId, long cadreId,
				String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeBySearchFilter(
			organizationId, tradeId, gradeId, designationId, designationGroupId,
			cadreId, keywords);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployeeList()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeList();
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployees()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployees();
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getEmployeesByKeywords(
				long organizationId, long tradeId, long gradeId,
				long designationId, long designationGroupId, String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeesByKeywords(
			organizationId, tradeId, gradeId, designationId, designationGroupId,
			keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getUserUnit() {

		return getService().getUserUnit();
	}

	public static void initEmployeesList() {
		getService().initEmployeesList();
	}

	public static boolean isUnique(
		long employeeId, java.util.Map<String, String> fieldValues) {

		return getService().isUnique(employeeId, fieldValues);
	}

	public static void performWorkFlowAction(long employeeId, String action)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().performWorkFlowAction(employeeId, action);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployees(java.util.Map<String, String> searchFilter) {

		return getService().searchEmployees(searchFilter);
	}

	public static void submitEmployeeJoining(long employeeId) {
		getService().submitEmployeeJoining(employeeId);
	}

	public static EmployeeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeService, EmployeeService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeService.class);

		ServiceTracker<EmployeeService, EmployeeService> serviceTracker =
			new ServiceTracker<EmployeeService, EmployeeService>(
				bundle.getBundleContext(), EmployeeService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}