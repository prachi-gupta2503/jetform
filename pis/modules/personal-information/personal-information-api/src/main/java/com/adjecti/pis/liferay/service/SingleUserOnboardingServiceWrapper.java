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

package com.adjecti.pis.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SingleUserOnboardingService}.
 *
 * @author Brian Wing Shun Chan
 * @see SingleUserOnboardingService
 * @generated
 */
public class SingleUserOnboardingServiceWrapper
	implements ServiceWrapper<SingleUserOnboardingService>,
			   SingleUserOnboardingService {

	public SingleUserOnboardingServiceWrapper(
		SingleUserOnboardingService singleUserOnboardingService) {

		_singleUserOnboardingService = singleUserOnboardingService;
	}

	@Override
	public int currentStatusBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingService.
			currentStatusBySingleUserOnboardingId(singleUserOnboardingId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _singleUserOnboardingService.getOSGiServiceIdentifier();
	}

	@Override
	public String updateStatusBySingleUserOnboardingId(
			long SingleUserOnboardingId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _singleUserOnboardingService.
			updateStatusBySingleUserOnboardingId(
				SingleUserOnboardingId, status);
	}

	@Override
	public SingleUserOnboardingService getWrappedService() {
		return _singleUserOnboardingService;
	}

	@Override
	public void setWrappedService(
		SingleUserOnboardingService singleUserOnboardingService) {

		_singleUserOnboardingService = singleUserOnboardingService;
	}

	private SingleUserOnboardingService _singleUserOnboardingService;

}