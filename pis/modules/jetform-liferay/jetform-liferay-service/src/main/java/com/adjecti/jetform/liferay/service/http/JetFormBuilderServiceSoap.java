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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>JetFormBuilderServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
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
 * @see JetFormBuilderServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class JetFormBuilderServiceSoap {

	public static com.adjecti.jetform.model.KeyValue
			getRelationObjectAsKeyValue(
				String objectClassName, String objectClassPK, String keyField,
				String valueField)
		throws RemoteException {

		try {
			com.adjecti.jetform.model.KeyValue returnValue =
				JetFormBuilderServiceUtil.getRelationObjectAsKeyValue(
					objectClassName, objectClassPK, keyField, valueField);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.jetform.model.KeyValue[] getListOptions(
			String entityClass, String searchField, String searchValue,
			String valueField, String labelField)
		throws RemoteException {

		try {
			java.util.List<com.adjecti.jetform.model.KeyValue> returnValue =
				JetFormBuilderServiceUtil.getListOptions(
					entityClass, searchField, searchValue, valueField,
					labelField);

			return returnValue.toArray(
				new com.adjecti.jetform.model.KeyValue[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String deleteEntity(
			String className, long id, boolean logical)
		throws RemoteException {

		try {
			String returnValue = JetFormBuilderServiceUtil.deleteEntity(
				className, id, logical);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long approveEntity(
			String className, long classPK, long userId, String remark)
		throws RemoteException {

		try {
			long returnValue = JetFormBuilderServiceUtil.approveEntity(
				className, classPK, userId, remark);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long rejectEntity(
			String className, long classPK, long userId, String remark)
		throws RemoteException {

		try {
			long returnValue = JetFormBuilderServiceUtil.rejectEntity(
				className, classPK, userId, remark);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String unDeleteEntity(String className, long id)
		throws RemoteException {

		try {
			String returnValue = JetFormBuilderServiceUtil.unDeleteEntity(
				className, id);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void generateForm(String formClass) throws RemoteException {
		try {
			JetFormBuilderServiceUtil.generateForm(formClass);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static boolean isUnique(
			String className, long id, String fieldName, String fieldValue)
		throws RemoteException {

		try {
			boolean returnValue = JetFormBuilderServiceUtil.isUnique(
				className, id, fieldName, fieldValue);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		JetFormBuilderServiceSoap.class);

}