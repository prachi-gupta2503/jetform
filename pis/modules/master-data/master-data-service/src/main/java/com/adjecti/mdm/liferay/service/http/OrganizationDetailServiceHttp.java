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

import com.adjecti.mdm.liferay.service.OrganizationDetailServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>OrganizationDetailServiceUtil</code> service
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
 * @see OrganizationDetailServiceSoap
 * @generated
 */
public class OrganizationDetailServiceHttp {

	public static com.liferay.portal.kernel.json.JSONArray getOrganizations(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "getOrganizations",
				_getOrganizationsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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
		getOrganizationsByType(HttpPrincipal httpPrincipal, String type) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "getOrganizationsByType",
				_getOrganizationsByTypeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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
		getOrganizationDetailByTypes(
			HttpPrincipal httpPrincipal, String[] type) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class,
				"getOrganizationDetailByTypes",
				_getOrganizationDetailByTypesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	public static com.liferay.portal.kernel.json.JSONObject
		getOrganizationHierarchy(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "getOrganizationHierarchy",
				_getOrganizationHierarchyParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	public static com.liferay.portal.kernel.json.JSONArray
		getOrganizationHierarchyByOrganizationId(
			HttpPrincipal httpPrincipal, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class,
				"getOrganizationHierarchyByOrganizationId",
				_getOrganizationHierarchyByOrganizationIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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
		getOrganizationsByParentIdAndType(
			HttpPrincipal httpPrincipal, long parentId, String type) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class,
				"getOrganizationsByParentIdAndType",
				_getOrganizationsByParentIdAndTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	public static com.liferay.portal.kernel.json.JSONObject getByOrganizationId(
		HttpPrincipal httpPrincipal, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "getByOrganizationId",
				_getByOrganizationIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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

	public static com.liferay.portal.kernel.json.JSONArray
		getChildOrganizations(HttpPrincipal httpPrincipal, long parentId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "getChildOrganizations",
				_getChildOrganizationsParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
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
		syncUnits(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "syncUnits",
				_syncUnitsParameterTypes11);

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

	public static com.liferay.portal.kernel.model.Organization saveOrganization(
			HttpPrincipal httpPrincipal, long organizationId, String code,
			String unitType, String name, String description, String type,
			long parentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String comments)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "saveOrganization",
				_saveOrganizationParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId, code, unitType, name, description,
				type, parentId, serviceContext, comments);

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

			return (com.liferay.portal.kernel.model.Organization)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.model.Organization updateStatus(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "updateStatus",
				_updateStatusParameterTypes13);

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

			return (com.liferay.portal.kernel.model.Organization)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static boolean removeOrganizationDetailByOrganizationId(
		HttpPrincipal httpPrincipal, long organizationDeatailId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class,
				"removeOrganizationDetailByOrganizationId",
				_removeOrganizationDetailByOrganizationIdParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationDeatailId);

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

	public static boolean dataIsAvailbleOrNot(
		HttpPrincipal httpPrincipal, String fieldName, String fieldValue,
		String type, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class, "dataIsAvailbleOrNot",
				_dataIsAvailbleOrNotParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fieldName, fieldValue, type, organizationId);

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

	public static boolean
		codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
			HttpPrincipal httpPrincipal, String type, long parentId,
			String fieldName, String fieldValue, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationDetailServiceUtil.class,
				"codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode",
				_codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCodeParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, type, parentId, fieldName, fieldValue,
				organizationId);

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

	private static Log _log = LogFactoryUtil.getLog(
		OrganizationDetailServiceHttp.class);

	private static final Class<?>[] _getOrganizationsParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _getOrganizationsByTypeParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[]
		_getOrganizationDetailByTypesParameterTypes2 = new Class[] {
			String[].class
		};
	private static final Class<?>[] _getOrganizationHierarchyParameterTypes3 =
		new Class[] {};
	private static final Class<?>[]
		_getOrganizationHierarchyByOrganizationIdParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getOrganizationsByParentIdAndTypeParameterTypes5 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _getByOrganizationIdParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _getChildOrganizationsParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _syncUnitsParameterTypes11 = new Class[] {};
	private static final Class<?>[] _saveOrganizationParameterTypes12 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			String.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class, String.class
		};
	private static final Class<?>[] _updateStatusParameterTypes13 =
		new Class[] {
			com.liferay.portal.kernel.theme.ThemeDisplay.class, String.class,
			long.class
		};
	private static final Class<?>[]
		_removeOrganizationDetailByOrganizationIdParameterTypes14 =
			new Class[] {long.class};
	private static final Class<?>[] _dataIsAvailbleOrNotParameterTypes15 =
		new Class[] {String.class, String.class, String.class, long.class};
	private static final Class<?>[]
		_codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCodeParameterTypes16 =
			new Class[] {
				String.class, long.class, String.class, String.class, long.class
			};

}