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
 * Provides a wrapper for {@link SpecializationService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpecializationService
 * @generated
 */
public class SpecializationServiceWrapper
	implements ServiceWrapper<SpecializationService>, SpecializationService {

	public SpecializationServiceWrapper(
		SpecializationService specializationService) {

		_specializationService = specializationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _specializationService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Specialization>
		getSpecializations() {

		return _specializationService.getSpecializations();
	}

	@Override
	public SpecializationService getWrappedService() {
		return _specializationService;
	}

	@Override
	public void setWrappedService(SpecializationService specializationService) {
		_specializationService = specializationService;
	}

	private SpecializationService _specializationService;

}