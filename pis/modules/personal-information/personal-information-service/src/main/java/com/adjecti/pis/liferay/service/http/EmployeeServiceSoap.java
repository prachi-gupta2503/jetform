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

package com.adjecti.pis.liferay.service.http;

import com.adjecti.pis.liferay.service.EmployeeServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>EmployeeServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.adjecti.pis.liferay.model.EmployeeSoap</code>. If the method in the
 * service utility returns a
 * <code>com.adjecti.pis.liferay.model.Employee</code>, that is translated to a
 * <code>com.adjecti.pis.liferay.model.EmployeeSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeServiceSoap {

	public static com.adjecti.pis.liferay.model.EmployeeSoap
			getEmployeeByEmployeeId(long employeeId)
		throws RemoteException {

		try {
			com.adjecti.pis.liferay.model.Employee returnValue =
				EmployeeServiceUtil.getEmployeeByEmployeeId(employeeId);

			return com.adjecti.pis.liferay.model.EmployeeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getEmployeeByPersonalNo(String personalNo)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				EmployeeServiceUtil.getEmployeeByPersonalNo(personalNo);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void submitEmployeeJoining(long employeeId)
		throws RemoteException {

		try {
			EmployeeServiceUtil.submitEmployeeJoining(employeeId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void performWorkFlowAction(long employeeId, String action)
		throws RemoteException {

		try {
			EmployeeServiceUtil.performWorkFlowAction(employeeId, action);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getEmployeeBySearchFilter(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroupId, long cadreId, String keywords)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				EmployeeServiceUtil.getEmployeeBySearchFilter(
					organizationId, tradeId, gradeId, designationId,
					designationGroupId, cadreId, keywords);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getEmployees() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				EmployeeServiceUtil.getEmployees();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getByTradeName(String tradeName)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				EmployeeServiceUtil.getByTradeName(tradeName);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getByGradeName(String gradeName)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				EmployeeServiceUtil.getByGradeName(gradeName);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getEmployeeList() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				EmployeeServiceUtil.getEmployeeList();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getEmployeesByKeywords(
			long organizationId, long tradeId, long gradeId, long designationId,
			long designationGroupId, String keywords)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				EmployeeServiceUtil.getEmployeesByKeywords(
					organizationId, tradeId, gradeId, designationId,
					designationGroupId, keywords);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.OrganizationSoap[]
			getUserUnit()
		throws RemoteException {

		try {
			java.util.List<com.liferay.portal.kernel.model.Organization>
				returnValue = EmployeeServiceUtil.getUserUnit();

			return com.liferay.portal.kernel.model.OrganizationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteByEmployeeId(long employeeId)
		throws RemoteException {

		try {
			EmployeeServiceUtil.deleteByEmployeeId(employeeId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void initEmployeesList() throws RemoteException {
		try {
			EmployeeServiceUtil.initEmployeesList();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EmployeeServiceSoap.class);

}