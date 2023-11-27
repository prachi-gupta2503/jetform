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
 * Provides a wrapper for {@link AppellationService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppellationService
 * @generated
 */
public class AppellationServiceWrapper
	implements AppellationService, ServiceWrapper<AppellationService> {

	public AppellationServiceWrapper(AppellationService appellationService) {
		_appellationService = appellationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appellationService.getOSGiServiceIdentifier();
	}

	@Override
	public AppellationService getWrappedService() {
		return _appellationService;
	}

	@Override
	public void setWrappedService(AppellationService appellationService) {
		_appellationService = appellationService;
	}

	private AppellationService _appellationService;

}