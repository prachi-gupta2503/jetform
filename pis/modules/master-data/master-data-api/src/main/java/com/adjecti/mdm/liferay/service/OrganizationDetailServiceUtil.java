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

package com.adjecti.mdm.liferay.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for OrganizationDetail. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.OrganizationDetailServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailService
 * @generated
 */
public class OrganizationDetailServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.OrganizationDetailServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean
		codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
			String type, long parentId, String fieldName, String fieldValue,
			long organizationId) {

		return getService().
			codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
				type, parentId, fieldName, fieldValue, organizationId);
	}

	public static boolean dataIsAvailbleOrNot(
		String fieldName, String fieldValue, String type, long organizationId) {

		return getService().dataIsAvailbleOrNot(
			fieldName, fieldValue, type, organizationId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getByOrganizationId(
		long organizationId) {

		return getService().getByOrganizationId(organizationId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getChildOrganizations(long parentId) {

		return getService().getChildOrganizations(parentId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getOrganizationDetailByTypes(String[] type) {

		return getService().getOrganizationDetailByTypes(type);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getOrganizationHierarchy() {

		return getService().getOrganizationHierarchy();
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getOrganizationHierarchyByOrganizationId(long organizationId) {

		return getService().getOrganizationHierarchyByOrganizationId(
			organizationId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getOrganizations() {
		return getService().getOrganizations();
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getOrganizationsByParentIdAndType(long parentId, String type) {

		return getService().getOrganizationsByParentIdAndType(parentId, type);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getOrganizationsByType(String type) {

		return getService().getOrganizationsByType(type);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static boolean removeOrganizationDetailByOrganizationId(
		long organizationDeatailId) {

		return getService().removeOrganizationDetailByOrganizationId(
			organizationDeatailId);
	}

	public static com.liferay.portal.kernel.model.Organization saveOrganization(
			long organizationId, String code, String unitType, String name,
			String description, String type, long parentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String comments)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().saveOrganization(
			organizationId, code, unitType, name, description, type, parentId,
			serviceContext, comments);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		syncUnits() {

		return getService().syncUnits();
	}

	public static com.liferay.portal.kernel.model.Organization updateStatus(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return getService().updateStatus(themeDisplay, status, organizationId);
	}

	public static OrganizationDetailService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationDetailService, OrganizationDetailService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationDetailService.class);

		ServiceTracker<OrganizationDetailService, OrganizationDetailService>
			serviceTracker =
				new ServiceTracker
					<OrganizationDetailService, OrganizationDetailService>(
						bundle.getBundleContext(),
						OrganizationDetailService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}