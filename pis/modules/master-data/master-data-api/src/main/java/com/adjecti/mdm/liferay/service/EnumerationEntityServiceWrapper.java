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
 * Provides a wrapper for {@link EnumerationEntityService}.
 *
 * @author Brian Wing Shun Chan
 * @see EnumerationEntityService
 * @generated
 */
public class EnumerationEntityServiceWrapper
	implements EnumerationEntityService,
			   ServiceWrapper<EnumerationEntityService> {

	public EnumerationEntityServiceWrapper(
		EnumerationEntityService enumerationEntityService) {

		_enumerationEntityService = enumerationEntityService;
	}

	@Override
	public com.adjecti.mdm.liferay.enumeration.model.AccomodationType
		getAccomodationType(int accomodationTypeId) {

		return _enumerationEntityService.getAccomodationType(
			accomodationTypeId);
	}

	@Override
	public java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.AccomodationType>
			getAccomodationTypes() {

		return _enumerationEntityService.getAccomodationTypes();
	}

	@Override
	public com.adjecti.mdm.liferay.enumeration.model.BloodGroup getBloodGroup(
		int bloodGroupId) {

		return _enumerationEntityService.getBloodGroup(bloodGroupId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.enumeration.model.BloodGroup>
		getBloodGroups() {

		return _enumerationEntityService.getBloodGroups();
	}

	@Override
	public com.adjecti.mdm.liferay.enumeration.model.CasteCategory
		getCasteCategory(int casteCategoryId) {

		return _enumerationEntityService.getCasteCategory(casteCategoryId);
	}

	@Override
	public java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.CasteCategory>
			getCasteCategorys() {

		return _enumerationEntityService.getCasteCategorys();
	}

	@Override
	public com.adjecti.mdm.liferay.enumeration.model.Gender getGender(
		int genderId) {

		return _enumerationEntityService.getGender(genderId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.enumeration.model.Gender>
		getGenders() {

		return _enumerationEntityService.getGenders();
	}

	@Override
	public com.adjecti.mdm.liferay.enumeration.model.MaritalStatus
		getMaritalStatus(int maritalStatusId) {

		return _enumerationEntityService.getMaritalStatus(maritalStatusId);
	}

	@Override
	public java.util.List
		<com.adjecti.mdm.liferay.enumeration.model.MaritalStatus>
			getMaritalStatuses() {

		return _enumerationEntityService.getMaritalStatuses();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _enumerationEntityService.getOSGiServiceIdentifier();
	}

	@Override
	public EnumerationEntityService getWrappedService() {
		return _enumerationEntityService;
	}

	@Override
	public void setWrappedService(
		EnumerationEntityService enumerationEntityService) {

		_enumerationEntityService = enumerationEntityService;
	}

	private EnumerationEntityService _enumerationEntityService;

}