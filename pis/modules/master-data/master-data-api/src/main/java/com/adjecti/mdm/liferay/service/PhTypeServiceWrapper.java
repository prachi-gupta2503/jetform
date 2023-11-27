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
 * Provides a wrapper for {@link PhTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhTypeService
 * @generated
 */
public class PhTypeServiceWrapper
	implements PhTypeService, ServiceWrapper<PhTypeService> {

	public PhTypeServiceWrapper(PhTypeService phTypeService) {
		_phTypeService = phTypeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public PhTypeService getWrappedService() {
		return _phTypeService;
	}

	@Override
	public void setWrappedService(PhTypeService phTypeService) {
		_phTypeService = phTypeService;
	}

	private PhTypeService _phTypeService;

}