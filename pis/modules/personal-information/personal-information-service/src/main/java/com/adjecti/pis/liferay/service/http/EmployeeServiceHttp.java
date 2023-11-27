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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>EmployeeServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeServiceSoap
 * @generated
 */
public class EmployeeServiceHttp {

	public static com.adjecti.pis.liferay.model.Employee
			getEmployeeByEmployeeId(
				HttpPrincipal httpPrincipal, long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployeeByEmployeeId",
				_getEmployeeByEmployeeIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.adjecti.pis.liferay.exception.
							NoSuchEmployeeException) {

					throw (com.adjecti.pis.liferay.exception.
						NoSuchEmployeeException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.pis.liferay.model.Employee)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject
			getEmployeeByPersonalNo(
				HttpPrincipal httpPrincipal, String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployeeByPersonalNo",
				_getEmployeeByPersonalNoParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, personalNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.adjecti.pis.liferay.exception.
							NoSuchEmployeeException) {

					throw (com.adjecti.pis.liferay.exception.
						NoSuchEmployeeException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void submitEmployeeJoining(
		HttpPrincipal httpPrincipal, long employeeId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "submitEmployeeJoining",
				_submitEmployeeJoiningParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void performWorkFlowAction(
			HttpPrincipal httpPrincipal, long employeeId, String action)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "performWorkFlowAction",
				_performWorkFlowActionParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId, action);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getEmployeeBySearchFilter(
				HttpPrincipal httpPrincipal, long organizationId, long tradeId,
				long gradeId, long designationId, long designationGroupId,
				long cadreId, String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployeeBySearchFilter",
				_getEmployeeBySearchFilterParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId, tradeId, gradeId, designationId,
				designationGroupId, cadreId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployees(
			HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployees",
				_getEmployeesParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getByTradeName(
			HttpPrincipal httpPrincipal, String tradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getByTradeName",
				_getByTradeNameParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tradeName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getByGradeName(
			HttpPrincipal httpPrincipal, String gradeName)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getByGradeName",
				_getByGradeNameParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, gradeName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getEmployeeList(
			HttpPrincipal httpPrincipal)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployeeList",
				_getEmployeeListParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getEmployeesByKeywords(
				HttpPrincipal httpPrincipal, long organizationId, long tradeId,
				long gradeId, long designationId, long designationGroupId,
				String keywords)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getEmployeesByKeywords",
				_getEmployeesByKeywordsParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId, tradeId, gradeId, designationId,
				designationGroupId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getUserUnit(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "getUserUnit",
				_getUserUnitParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.portal.kernel.model.Organization>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteByEmployeeId(
			HttpPrincipal httpPrincipal, long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "deleteByEmployeeId",
				_deleteByEmployeeIdParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.adjecti.pis.liferay.model.Employee>
		searchEmployees(
			HttpPrincipal httpPrincipal,
			java.util.Map<String, String> searchFilter) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "searchEmployees",
				_searchEmployeesParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, searchFilter);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.adjecti.pis.liferay.model.Employee>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static boolean isUnique(
		HttpPrincipal httpPrincipal, long employeeId,
		java.util.Map<String, String> fieldValues) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "isUnique",
				_isUniqueParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId, fieldValues);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void initEmployeesList(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(
				EmployeeServiceUtil.class, "initEmployeesList",
				_initEmployeesListParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EmployeeServiceHttp.class);

	private static final Class<?>[] _getEmployeeByEmployeeIdParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _getEmployeeByPersonalNoParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[] _submitEmployeeJoiningParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _performWorkFlowActionParameterTypes3 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _getEmployeeBySearchFilterParameterTypes4 =
		new Class[] {
			long.class, long.class, long.class, long.class, long.class,
			long.class, String.class
		};
	private static final Class<?>[] _getEmployeesParameterTypes5 =
		new Class[] {};
	private static final Class<?>[] _getByTradeNameParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _getByGradeNameParameterTypes7 =
		new Class[] {String.class};
	private static final Class<?>[] _getEmployeeListParameterTypes8 =
		new Class[] {};
	private static final Class<?>[] _getEmployeesByKeywordsParameterTypes9 =
		new Class[] {
			long.class, long.class, long.class, long.class, long.class,
			String.class
		};
	private static final Class<?>[] _getUserUnitParameterTypes10 =
		new Class[] {};
	private static final Class<?>[] _deleteByEmployeeIdParameterTypes11 =
		new Class[] {long.class};
	private static final Class<?>[] _searchEmployeesParameterTypes12 =
		new Class[] {java.util.Map.class};
	private static final Class<?>[] _isUniqueParameterTypes13 = new Class[] {
		long.class, java.util.Map.class
	};
	private static final Class<?>[] _initEmployeesListParameterTypes14 =
		new Class[] {};

}