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

package com.adjecti.mdm.liferay.service.http;

import com.adjecti.mdm.liferay.service.DesignationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>DesignationServiceUtil</code> service
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
 * @see DesignationServiceSoap
 * @generated
 */
public class DesignationServiceHttp {

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignations(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				DesignationServiceUtil.class, "getDesignations",
				_getDesignationsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.adjecti.mdm.liferay.model.Designation>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByGradeId(HttpPrincipal httpPrincipal, long gradeId) {

		try {
			MethodKey methodKey = new MethodKey(
				DesignationServiceUtil.class, "getDesignationsByGradeId",
				_getDesignationsByGradeIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, gradeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.adjecti.mdm.liferay.model.Designation>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationClassId(
			HttpPrincipal httpPrincipal, long designationClassId) {

		try {
			MethodKey methodKey = new MethodKey(
				DesignationServiceUtil.class,
				"getDesignationsByDesignationClassId",
				_getDesignationsByDesignationClassIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, designationClassId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.adjecti.mdm.liferay.model.Designation>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationGroupId(
			HttpPrincipal httpPrincipal, long designationGroupId) {

		try {
			MethodKey methodKey = new MethodKey(
				DesignationServiceUtil.class,
				"getDesignationsByDesignationGroupId",
				_getDesignationsByDesignationGroupIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, designationGroupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.adjecti.mdm.liferay.model.Designation>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.adjecti.mdm.liferay.model.Grade getGradesByDesignationId(
		HttpPrincipal httpPrincipal, long designationId) {

		try {
			MethodKey methodKey = new MethodKey(
				DesignationServiceUtil.class, "getGradesByDesignationId",
				_getGradesByDesignationIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, designationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.mdm.liferay.model.Grade)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByCadreId(HttpPrincipal httpPrincipal, long cadreId) {

		try {
			MethodKey methodKey = new MethodKey(
				DesignationServiceUtil.class, "getDesignationsByCadreId",
				_getDesignationsByCadreIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, cadreId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.adjecti.mdm.liferay.model.Designation>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DesignationServiceHttp.class);

	private static final Class<?>[] _getDesignationsParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _getDesignationsByGradeIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getDesignationsByDesignationClassIdParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getDesignationsByDesignationGroupIdParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getGradesByDesignationIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getDesignationsByCadreIdParameterTypes5 =
		new Class[] {long.class};

}