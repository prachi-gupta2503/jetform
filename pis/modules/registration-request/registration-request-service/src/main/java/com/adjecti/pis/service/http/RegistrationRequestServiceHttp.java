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

package com.adjecti.pis.service.http;

import com.adjecti.pis.service.RegistrationRequestServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>RegistrationRequestServiceUtil</code> service
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
 * @see RegistrationRequestServiceSoap
 * @generated
 */
public class RegistrationRequestServiceHttp {

	public static String createUser(
		HttpPrincipal httpPrincipal, long registrationRequestId) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationRequestServiceUtil.class, "createUser",
				_createUserParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationRequestId);

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

	public static com.adjecti.pis.model.RegistrationRequest
			deleteRegistrationRequest(
				HttpPrincipal httpPrincipal, long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationRequestServiceUtil.class,
				"deleteRegistrationRequest",
				_deleteRegistrationRequestParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, requestId);

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

			return (com.adjecti.pis.model.RegistrationRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.Map<String, java.util.List<String>>
		deduplicateLoginIds(
			HttpPrincipal httpPrincipal, String duplicateLoginIds) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationRequestServiceUtil.class, "deduplicateLoginIds",
				_deduplicateLoginIdsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, duplicateLoginIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.Map<String, java.util.List<String>>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.adjecti.pis.liferay.model.Employee createEmployee(
		HttpPrincipal httpPrincipal, long requestId) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationRequestServiceUtil.class, "createEmployee",
				_createEmployeeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, requestId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	public static com.liferay.portal.kernel.model.User createAppUser(
		HttpPrincipal httpPrincipal, long requestId, long employeeId) {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationRequestServiceUtil.class, "createAppUser",
				_createAppUserParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, requestId, employeeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.model.User)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String createUserWithPermission(
			HttpPrincipal httpPrincipal, long registrationRequestId,
			boolean emailAccess, boolean digitalSigning, boolean eGovAccess,
			boolean pisAccess)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		try {
			MethodKey methodKey = new MethodKey(
				RegistrationRequestServiceUtil.class,
				"createUserWithPermission",
				_createUserWithPermissionParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationRequestId, emailAccess, digitalSigning,
				eGovAccess, pisAccess);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.adjecti.pis.exception.
							NoSuchRegistrationRequestException) {

					throw (com.adjecti.pis.exception.
						NoSuchRegistrationRequestException)exception;
				}

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
		RegistrationRequestServiceHttp.class);

	private static final Class<?>[] _createUserParameterTypes0 = new Class[] {
		long.class
	};
	private static final Class<?>[] _deleteRegistrationRequestParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _deduplicateLoginIdsParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _createEmployeeParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _createAppUserParameterTypes4 =
		new Class[] {long.class, long.class};
	private static final Class<?>[] _createUserWithPermissionParameterTypes5 =
		new Class[] {
			long.class, boolean.class, boolean.class, boolean.class,
			boolean.class
		};

}