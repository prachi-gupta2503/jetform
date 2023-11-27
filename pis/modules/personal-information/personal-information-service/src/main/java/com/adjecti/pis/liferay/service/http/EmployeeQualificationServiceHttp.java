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

import com.adjecti.pis.liferay.service.EmployeeQualificationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>EmployeeQualificationServiceUtil</code> service
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
 * @see EmployeeQualificationServiceSoap
 * @generated
 */
public class EmployeeQualificationServiceHttp {

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
				addEmployeeQualification(
					HttpPrincipal httpPrincipal,
					java.util.List
						<com.adjecti.pis.liferay.model.EmployeeQualification>
							employeeQualification)
			throws com.adjecti.pis.liferay.exception.
				EmployeeQualificationException,
				   com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeQualificationServiceUtil.class,
				"addEmployeeQualification",
				_addEmployeeQualificationParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeQualification);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.adjecti.pis.liferay.exception.
							EmployeeQualificationException) {

					throw (com.adjecti.pis.liferay.exception.
						EmployeeQualificationException)exception;
				}

				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.adjecti.pis.liferay.model.EmployeeQualification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
			getQualificationByEmployeeId(
				HttpPrincipal httpPrincipal, long employeeId) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeQualificationServiceUtil.class,
				"getQualificationByEmployeeId",
				_getQualificationByEmployeeIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, employeeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.adjecti.pis.liferay.model.EmployeeQualification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification> getByPersonalNo(
			HttpPrincipal httpPrincipal, String personalNo) {

		try {
			MethodKey methodKey = new MethodKey(
				EmployeeQualificationServiceUtil.class, "getByPersonalNo",
				_getByPersonalNoParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, personalNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.adjecti.pis.liferay.model.EmployeeQualification>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		EmployeeQualificationServiceHttp.class);

	private static final Class<?>[] _addEmployeeQualificationParameterTypes0 =
		new Class[] {java.util.List.class};
	private static final Class<?>[]
		_getQualificationByEmployeeIdParameterTypes1 = new Class[] {long.class};
	private static final Class<?>[] _getByPersonalNoParameterTypes2 =
		new Class[] {String.class};

}