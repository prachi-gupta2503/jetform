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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrganizationDetailService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailService
 * @generated
 */
public class OrganizationDetailServiceWrapper
	implements OrganizationDetailService,
			   ServiceWrapper<OrganizationDetailService> {

	public OrganizationDetailServiceWrapper(
		OrganizationDetailService organizationDetailService) {

		_organizationDetailService = organizationDetailService;
	}

	@Override
	public boolean codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
		String type, long parentId, String fieldName, String fieldValue,
		long organizationId) {

		return _organizationDetailService.
			codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
				type, parentId, fieldName, fieldValue, organizationId);
	}

	@Override
	public boolean dataIsAvailbleOrNot(
		String fieldName, String fieldValue, String type, long organizationId) {

		return _organizationDetailService.dataIsAvailbleOrNot(
			fieldName, fieldValue, type, organizationId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getByOrganizationId(
		long organizationId) {

		return _organizationDetailService.getByOrganizationId(organizationId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getChildOrganizations(
		long parentId) {

		return _organizationDetailService.getChildOrganizations(parentId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getOrganizationDetailByTypes(String[] type) {

		return _organizationDetailService.getOrganizationDetailByTypes(type);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject
		getOrganizationHierarchy() {

		return _organizationDetailService.getOrganizationHierarchy();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getOrganizationHierarchyByOrganizationId(long organizationId) {

		return _organizationDetailService.
			getOrganizationHierarchyByOrganizationId(organizationId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getOrganizations() {
		return _organizationDetailService.getOrganizations();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getOrganizationsByParentIdAndType(long parentId, String type) {

		return _organizationDetailService.getOrganizationsByParentIdAndType(
			parentId, type);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getOrganizationsByType(
		String type) {

		return _organizationDetailService.getOrganizationsByType(type);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationDetailService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean removeOrganizationDetailByOrganizationId(
		long organizationDeatailId) {

		return _organizationDetailService.
			removeOrganizationDetailByOrganizationId(organizationDeatailId);
	}

	@Override
	public com.liferay.portal.kernel.model.Organization saveOrganization(
			long organizationId, String code, String unitType, String name,
			String description, String type, long parentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String comments)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationDetailService.saveOrganization(
			organizationId, code, unitType, name, description, type, parentId,
			serviceContext, comments);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		syncUnits() {

		return _organizationDetailService.syncUnits();
	}

	@Override
	public com.liferay.portal.kernel.model.Organization updateStatus(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return _organizationDetailService.updateStatus(
			themeDisplay, status, organizationId);
	}

	@Override
	public OrganizationDetailService getWrappedService() {
		return _organizationDetailService;
	}

	@Override
	public void setWrappedService(
		OrganizationDetailService organizationDetailService) {

		_organizationDetailService = organizationDetailService;
	}

	private OrganizationDetailService _organizationDetailService;

}