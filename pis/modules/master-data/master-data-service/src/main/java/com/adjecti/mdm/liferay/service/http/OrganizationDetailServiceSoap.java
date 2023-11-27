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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>OrganizationDetailServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.adjecti.mdm.liferay.model.OrganizationDetailSoap</code>. If the method in the
 * service utility returns a
 * <code>com.adjecti.mdm.liferay.model.OrganizationDetail</code>, that is translated to a
 * <code>com.adjecti.mdm.liferay.model.OrganizationDetailSoap</code>. Methods that SOAP
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
 * @see OrganizationDetailServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OrganizationDetailServiceSoap {

	public static String getOrganizations() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				OrganizationDetailServiceUtil.getOrganizations();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getOrganizationsByType(String type)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				OrganizationDetailServiceUtil.getOrganizationsByType(type);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getOrganizationDetailByTypes(String[] type)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				OrganizationDetailServiceUtil.getOrganizationDetailByTypes(
					type);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getOrganizationHierarchy() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				OrganizationDetailServiceUtil.getOrganizationHierarchy();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getOrganizationHierarchyByOrganizationId(
			long organizationId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				OrganizationDetailServiceUtil.
					getOrganizationHierarchyByOrganizationId(organizationId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getOrganizationsByParentIdAndType(
			long parentId, String type)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				OrganizationDetailServiceUtil.getOrganizationsByParentIdAndType(
					parentId, type);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getByOrganizationId(long organizationId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				OrganizationDetailServiceUtil.getByOrganizationId(
					organizationId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getChildOrganizations(long parentId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				OrganizationDetailServiceUtil.getChildOrganizations(parentId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.OrganizationSoap[] syncUnits()
		throws RemoteException {

		try {
			java.util.List<com.liferay.portal.kernel.model.Organization>
				returnValue = OrganizationDetailServiceUtil.syncUnits();

			return com.liferay.portal.kernel.model.OrganizationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.Organization saveOrganization(
			long organizationId, String code, String unitType, String name,
			String description, String type, long parentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String comments)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.model.Organization returnValue =
				OrganizationDetailServiceUtil.saveOrganization(
					organizationId, code, unitType, name, description, type,
					parentId, serviceContext, comments);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static boolean removeOrganizationDetailByOrganizationId(
			long organizationDeatailId)
		throws RemoteException {

		try {
			boolean returnValue =
				OrganizationDetailServiceUtil.
					removeOrganizationDetailByOrganizationId(
						organizationDeatailId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static boolean dataIsAvailbleOrNot(
			String fieldName, String fieldValue, String type,
			long organizationId)
		throws RemoteException {

		try {
			boolean returnValue =
				OrganizationDetailServiceUtil.dataIsAvailbleOrNot(
					fieldName, fieldValue, type, organizationId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static boolean
			codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
				String type, long parentId, String fieldName, String fieldValue,
				long organizationId)
		throws RemoteException {

		try {
			boolean returnValue =
				OrganizationDetailServiceUtil.
					codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
						type, parentId, fieldName, fieldValue, organizationId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		OrganizationDetailServiceSoap.class);

}