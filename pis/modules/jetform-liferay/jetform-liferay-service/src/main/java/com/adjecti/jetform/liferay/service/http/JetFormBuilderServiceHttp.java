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

package com.adjecti.jetform.liferay.service.http;

import com.adjecti.jetform.liferay.service.JetFormBuilderServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>JetFormBuilderServiceUtil</code> service
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
 * @see JetFormBuilderServiceSoap
 * @generated
 */
public class JetFormBuilderServiceHttp {

	public static String saveForm(
		HttpPrincipal httpPrincipal, java.util.Map<String, Object> params) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "saveForm",
				_saveFormParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, params);

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

	public static com.liferay.portal.kernel.json.JSONArray readObjectsAsJson(
		HttpPrincipal httpPrincipal,
		java.util.Map<String, String> searchFilter) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "readObjectsAsJson",
				_readObjectsAsJsonParameterTypes1);

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

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.adjecti.jetform.model.KeyValue
		getRelationObjectAsKeyValue(
			HttpPrincipal httpPrincipal, String objectClassName,
			String objectClassPK, String keyField, String valueField) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "getRelationObjectAsKeyValue",
				_getRelationObjectAsKeyValueParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, objectClassName, objectClassPK, keyField,
				valueField);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.jetform.model.KeyValue)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.adjecti.jetform.model.KeyValue>
		getListOptions(
			HttpPrincipal httpPrincipal, String entityClass, String searchField,
			String searchValue, String valueField, String labelField) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "getListOptions",
				_getListOptionsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, entityClass, searchField, searchValue, valueField,
				labelField);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.adjecti.jetform.model.KeyValue>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String deleteEntity(
		HttpPrincipal httpPrincipal, String className, long id,
		boolean logical) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "deleteEntity",
				_deleteEntityParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, className, id, logical);

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

	public static long approveEntity(
		HttpPrincipal httpPrincipal, String className, long classPK,
		long userId, String remark) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "approveEntity",
				_approveEntityParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, className, classPK, userId, remark);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long rejectEntity(
		HttpPrincipal httpPrincipal, String className, long classPK,
		long userId, String remark) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "rejectEntity",
				_rejectEntityParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, className, classPK, userId, remark);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.Map<String, String> importExcel(
		HttpPrincipal httpPrincipal, String formClass, long fileEntryId) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "importExcel",
				_importExcelParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, formClass, fileEntryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.Map<String, String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String unDeleteEntity(
		HttpPrincipal httpPrincipal, String className, long id) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "unDeleteEntity",
				_unDeleteEntityParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, className, id);

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

	public static void generateForm(
			HttpPrincipal httpPrincipal, String formClass)
		throws ClassNotFoundException {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "generateForm",
				_generateFormParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, formClass);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof ClassNotFoundException) {
					throw (ClassNotFoundException)exception;
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

	public static boolean isUnique(
		HttpPrincipal httpPrincipal, String className, long id,
		String fieldName, String fieldValue) {

		try {
			MethodKey methodKey = new MethodKey(
				JetFormBuilderServiceUtil.class, "isUnique",
				_isUniqueParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, className, id, fieldName, fieldValue);

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
		JetFormBuilderServiceHttp.class);

	private static final Class<?>[] _saveFormParameterTypes0 = new Class[] {
		java.util.Map.class
	};
	private static final Class<?>[] _readObjectsAsJsonParameterTypes1 =
		new Class[] {java.util.Map.class};
	private static final Class<?>[]
		_getRelationObjectAsKeyValueParameterTypes2 = new Class[] {
			String.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _getListOptionsParameterTypes3 =
		new Class[] {
			String.class, String.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _deleteEntityParameterTypes4 = new Class[] {
		String.class, long.class, boolean.class
	};
	private static final Class<?>[] _approveEntityParameterTypes5 =
		new Class[] {String.class, long.class, long.class, String.class};
	private static final Class<?>[] _rejectEntityParameterTypes6 = new Class[] {
		String.class, long.class, long.class, String.class
	};
	private static final Class<?>[] _importExcelParameterTypes7 = new Class[] {
		String.class, long.class
	};
	private static final Class<?>[] _unDeleteEntityParameterTypes8 =
		new Class[] {String.class, long.class};
	private static final Class<?>[] _generateFormParameterTypes9 = new Class[] {
		String.class
	};
	private static final Class<?>[] _isUniqueParameterTypes10 = new Class[] {
		String.class, long.class, String.class, String.class
	};

}