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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for OrganizationDetail. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OrganizationDetailService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.OrganizationDetailServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the organization detail remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link OrganizationDetailServiceUtil} if injection and service tracking are not available.
	 */
	public boolean codeIsAvailableOrNotBasedOnTypeAndUnitAndOrganizationCode(
		String type, long parentId, String fieldName, String fieldValue,
		long organizationId);

	public boolean dataIsAvailbleOrNot(
		String fieldName, String fieldValue, String type, long organizationId);

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getByOrganizationId(long organizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getChildOrganizations(long parentId);

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getOrganizationDetailByTypes(String[] type);

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getOrganizationHierarchy();

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getOrganizationHierarchyByOrganizationId(
		long organizationId);

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getOrganizations();

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getOrganizationsByParentIdAndType(
		long parentId, String type);

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getOrganizationsByType(String type);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public boolean removeOrganizationDetailByOrganizationId(
		long organizationDeatailId);

	public Organization saveOrganization(
			long organizationId, String code, String unitType, String name,
			String description, String type, long parentId,
			ServiceContext serviceContext, String comments)
		throws PortalException;

	public List<Organization> syncUnits();

	public Organization updateStatus(
		ThemeDisplay themeDisplay, String status, long organizationId);

}