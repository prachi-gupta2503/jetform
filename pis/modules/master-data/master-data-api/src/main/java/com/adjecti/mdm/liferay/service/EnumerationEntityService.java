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

import com.adjecti.mdm.liferay.enumeration.model.AccomodationType;
import com.adjecti.mdm.liferay.enumeration.model.BloodGroup;
import com.adjecti.mdm.liferay.enumeration.model.CasteCategory;
import com.adjecti.mdm.liferay.enumeration.model.Gender;
import com.adjecti.mdm.liferay.enumeration.model.MaritalStatus;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for EnumerationEntity. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EnumerationEntityServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EnumerationEntityService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.EnumerationEntityServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the enumeration entity remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EnumerationEntityServiceUtil} if injection and service tracking are not available.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccomodationType getAccomodationType(int accomodationTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccomodationType> getAccomodationTypes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BloodGroup getBloodGroup(int bloodGroupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BloodGroup> getBloodGroups();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CasteCategory getCasteCategory(int casteCategoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CasteCategory> getCasteCategorys();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Gender getGender(int genderId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Gender> getGenders();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MaritalStatus getMaritalStatus(int maritalStatusId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MaritalStatus> getMaritalStatuses();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}