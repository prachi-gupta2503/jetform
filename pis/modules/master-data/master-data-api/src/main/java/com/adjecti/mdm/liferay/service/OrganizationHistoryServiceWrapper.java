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
 * Provides a wrapper for {@link OrganizationHistoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationHistoryService
 * @generated
 */
public class OrganizationHistoryServiceWrapper
	implements OrganizationHistoryService,
			   ServiceWrapper<OrganizationHistoryService> {

	public OrganizationHistoryServiceWrapper(
		OrganizationHistoryService organizationHistoryService) {

		_organizationHistoryService = organizationHistoryService;
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationHistory>
		getByPreviousOrganizationId(long organizationId) {

		return _organizationHistoryService.getByPreviousOrganizationId(
			organizationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationHistoryService.getOSGiServiceIdentifier();
	}

	@Override
	public void saveSplitOrganizationHistory(
		java.util.List<Long> organizationIds, long originalSectionId,
		String status) {

		_organizationHistoryService.saveSplitOrganizationHistory(
			organizationIds, originalSectionId, status);
	}

	@Override
	public OrganizationHistoryService getWrappedService() {
		return _organizationHistoryService;
	}

	@Override
	public void setWrappedService(
		OrganizationHistoryService organizationHistoryService) {

		_organizationHistoryService = organizationHistoryService;
	}

	private OrganizationHistoryService _organizationHistoryService;

}