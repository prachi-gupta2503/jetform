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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>EnumerationEntityServiceUtil</code> service
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
 * @see EnumerationEntityServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EnumerationEntityServiceSoap {

	public static com.adjecti.mdm.liferay.enumeration.model.Gender getGender(
			int genderId)
		throws RemoteException {

		try {
			com.adjecti.mdm.liferay.enumeration.model.Gender returnValue =
				EnumerationEntityServiceUtil.getGender(genderId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.Gender[]
			getGenders()
		throws RemoteException {

		try {
			java.util.List<com.adjecti.mdm.liferay.enumeration.model.Gender>
				returnValue = EnumerationEntityServiceUtil.getGenders();

			return returnValue.toArray(
				new com.adjecti.mdm.liferay.enumeration.model.Gender
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.AccomodationType
			getAccomodationType(int accomodationTypeId)
		throws RemoteException {

		try {
			com.adjecti.mdm.liferay.enumeration.model.AccomodationType
				returnValue = EnumerationEntityServiceUtil.getAccomodationType(
					accomodationTypeId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.AccomodationType[]
			getAccomodationTypes()
		throws RemoteException {

		try {
			java.util.List
				<com.adjecti.mdm.liferay.enumeration.model.AccomodationType>
					returnValue =
						EnumerationEntityServiceUtil.getAccomodationTypes();

			return returnValue.toArray(
				new com.adjecti.mdm.liferay.enumeration.model.AccomodationType
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.BloodGroup
			getBloodGroup(int bloodGroupId)
		throws RemoteException {

		try {
			com.adjecti.mdm.liferay.enumeration.model.BloodGroup returnValue =
				EnumerationEntityServiceUtil.getBloodGroup(bloodGroupId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.BloodGroup[]
			getBloodGroups()
		throws RemoteException {

		try {
			java.util.List<com.adjecti.mdm.liferay.enumeration.model.BloodGroup>
				returnValue = EnumerationEntityServiceUtil.getBloodGroups();

			return returnValue.toArray(
				new com.adjecti.mdm.liferay.enumeration.model.BloodGroup
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.MaritalStatus
			getMaritalStatus(int maritalStatusId)
		throws RemoteException {

		try {
			com.adjecti.mdm.liferay.enumeration.model.MaritalStatus
				returnValue = EnumerationEntityServiceUtil.getMaritalStatus(
					maritalStatusId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.MaritalStatus[]
			getMaritalStatuses()
		throws RemoteException {

		try {
			java.util.List
				<com.adjecti.mdm.liferay.enumeration.model.MaritalStatus>
					returnValue =
						EnumerationEntityServiceUtil.getMaritalStatuses();

			return returnValue.toArray(
				new com.adjecti.mdm.liferay.enumeration.model.MaritalStatus
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.CasteCategory
			getCasteCategory(int casteCategoryId)
		throws RemoteException {

		try {
			com.adjecti.mdm.liferay.enumeration.model.CasteCategory
				returnValue = EnumerationEntityServiceUtil.getCasteCategory(
					casteCategoryId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.adjecti.mdm.liferay.enumeration.model.CasteCategory[]
			getCasteCategorys()
		throws RemoteException {

		try {
			java.util.List
				<com.adjecti.mdm.liferay.enumeration.model.CasteCategory>
					returnValue =
						EnumerationEntityServiceUtil.getCasteCategorys();

			return returnValue.toArray(
				new com.adjecti.mdm.liferay.enumeration.model.CasteCategory
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		EnumerationEntityServiceSoap.class);

}