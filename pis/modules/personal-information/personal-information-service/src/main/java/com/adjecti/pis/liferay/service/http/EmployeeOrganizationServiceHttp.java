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

import com.adjecti.pis.liferay.service.EmployeeOrganizationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>EmployeeOrganizationServiceUtil</code> service
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
 * @see EmployeeOrganizationServiceSoap
 * @generated
 */
public class EmployeeOrganizationServiceHttp {

	public static boolean existsEmployeeOrganization(
		HttpPrincipal httpPrincipal, long employeeId, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeOrganizationServiceUtil.class,
				"existsEmployeeOrganization",
				_existsEmployeeOrganizationParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId, organizationId);

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

	public static boolean existsEmployeeSubOrganization(
		HttpPrincipal httpPrincipal, long employeeId, long subOrganizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeOrganizationServiceUtil.class,
				"existsEmployeeSubOrganization",
				_existsEmployeeSubOrganizationParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId, subOrganizationId);

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

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getByEmployeeIdAndOrganizationId(
				HttpPrincipal httpPrincipal, long employeeId,
				long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeOrganizationServiceUtil.class,
				"getByEmployeeIdAndOrganizationId",
				_getByEmployeeIdAndOrganizationIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.adjecti.pis.liferay.model.EmployeeOrganization>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getNonAssignedOrganizationsOfEmployee(
			HttpPrincipal httpPrincipal, long parentId, String type,
			long employeeId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeOrganizationServiceUtil.class,
				"getNonAssignedOrganizationsOfEmployee",
				_getNonAssignedOrganizationsOfEmployeeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, type, employeeId);

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

	public static String updateOrganization(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeOrganizationServiceUtil.class, "updateOrganization",
				_updateOrganizationParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, themeDisplay, status, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		EmployeeOrganizationServiceHttp.class);

	private static final Class<?>[] _existsEmployeeOrganizationParameterTypes0 =
		new Class[] {long.class, long.class};
	private static final Class<?>[]
		_existsEmployeeSubOrganizationParameterTypes1 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[]
		_getByEmployeeIdAndOrganizationIdParameterTypes2 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[]
		_getNonAssignedOrganizationsOfEmployeeParameterTypes3 = new Class[] {
			long.class, String.class, long.class
		};
	private static final Class<?>[] _updateOrganizationParameterTypes4 =
		new Class[] {
			com.liferay.portal.kernel.theme.ThemeDisplay.class, String.class,
			long.class
		};

}