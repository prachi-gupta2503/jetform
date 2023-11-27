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

import com.adjecti.mdm.liferay.service.OrganizationHistoryServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>OrganizationHistoryServiceUtil</code> service
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
 * @see OrganizationHistoryServiceSoap
 * @generated
 */
public class OrganizationHistoryServiceHttp {

	public static void saveSplitOrganizationHistory(
		HttpPrincipal httpPrincipal, java.util.List<Long> organizationIds,
		long originalSectionId, String status) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationHistoryServiceUtil.class,
				"saveSplitOrganizationHistory",
				_saveSplitOrganizationHistoryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationIds, originalSectionId, status);

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

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationHistory>
			getByPreviousOrganizationId(
				HttpPrincipal httpPrincipal, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				OrganizationHistoryServiceUtil.class,
				"getByPreviousOrganizationId",
				_getByPreviousOrganizationIdParameterTypes1);

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

			return (java.util.List
				<com.adjecti.mdm.liferay.model.OrganizationHistory>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		OrganizationHistoryServiceHttp.class);

	private static final Class<?>[]
		_saveSplitOrganizationHistoryParameterTypes0 = new Class[] {
			java.util.List.class, long.class, String.class
		};
	private static final Class<?>[]
		_getByPreviousOrganizationIdParameterTypes1 = new Class[] {long.class};

}