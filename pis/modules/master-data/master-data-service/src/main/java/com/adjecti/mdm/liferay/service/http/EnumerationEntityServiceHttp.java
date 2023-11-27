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

import com.adjecti.mdm.liferay.service.EnumerationEntityServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>EnumerationEntityServiceUtil</code> service
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
 * @see EnumerationEntityServiceSoap
 * @generated
 */
public class EnumerationEntityServiceHttp {

	public static com.adjecti.mdm.liferay.enumeration.model.Gender getGender(
		HttpPrincipal httpPrincipal, int genderId) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getGender",
				_getGenderParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, genderId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.mdm.liferay.enumeration.model.Gender)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.Gender> getGenders(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getGenders",
				_getGendersParameterTypes1);

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
				<com.adjecti.mdm.liferay.enumeration.model.Gender>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.AccomodationType
		getAccomodationType(
			HttpPrincipal httpPrincipal, int accomodationTypeId) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getAccomodationType",
				_getAccomodationTypeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accomodationTypeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.mdm.liferay.enumeration.model.AccomodationType)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.AccomodationType>
			getAccomodationTypes(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getAccomodationTypes",
				_getAccomodationTypesParameterTypes3);

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
				<com.adjecti.mdm.liferay.enumeration.model.AccomodationType>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.BloodGroup
		getBloodGroup(HttpPrincipal httpPrincipal, int bloodGroupId) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getBloodGroup",
				_getBloodGroupParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bloodGroupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.mdm.liferay.enumeration.model.BloodGroup)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.BloodGroup> getBloodGroups(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getBloodGroups",
				_getBloodGroupsParameterTypes5);

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
				<com.adjecti.mdm.liferay.enumeration.model.BloodGroup>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.MaritalStatus
		getMaritalStatus(HttpPrincipal httpPrincipal, int maritalStatusId) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getMaritalStatus",
				_getMaritalStatusParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, maritalStatusId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.mdm.liferay.enumeration.model.MaritalStatus)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.MaritalStatus>
			getMaritalStatuses(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getMaritalStatuses",
				_getMaritalStatusesParameterTypes7);

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
				<com.adjecti.mdm.liferay.enumeration.model.MaritalStatus>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.CasteCategory
		getCasteCategory(HttpPrincipal httpPrincipal, int casteCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getCasteCategory",
				_getCasteCategoryParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, casteCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.adjecti.mdm.liferay.enumeration.model.CasteCategory)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.CasteCategory>
			getCasteCategorys(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				EnumerationEntityServiceUtil.class, "getCasteCategorys",
				_getCasteCategorysParameterTypes9);

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
				<com.adjecti.mdm.liferay.enumeration.model.CasteCategory>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		EnumerationEntityServiceHttp.class);

	private static final Class<?>[] _getGenderParameterTypes0 = new Class[] {
		int.class
	};
	private static final Class<?>[] _getGendersParameterTypes1 = new Class[] {};
	private static final Class<?>[] _getAccomodationTypeParameterTypes2 =
		new Class[] {int.class};
	private static final Class<?>[] _getAccomodationTypesParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _getBloodGroupParameterTypes4 =
		new Class[] {int.class};
	private static final Class<?>[] _getBloodGroupsParameterTypes5 =
		new Class[] {};
	private static final Class<?>[] _getMaritalStatusParameterTypes6 =
		new Class[] {int.class};
	private static final Class<?>[] _getMaritalStatusesParameterTypes7 =
		new Class[] {};
	private static final Class<?>[] _getCasteCategoryParameterTypes8 =
		new Class[] {int.class};
	private static final Class<?>[] _getCasteCategorysParameterTypes9 =
		new Class[] {};

}