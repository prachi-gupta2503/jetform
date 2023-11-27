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
 * Provides a wrapper for {@link PayStructureService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayStructureService
 * @generated
 */
public class PayStructureServiceWrapper
	implements PayStructureService, ServiceWrapper<PayStructureService> {

	public PayStructureServiceWrapper(PayStructureService payStructureService) {
		_payStructureService = payStructureService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _payStructureService.getOSGiServiceIdentifier();
	}

	@Override
	public PayStructureService getWrappedService() {
		return _payStructureService;
	}

	@Override
	public void setWrappedService(PayStructureService payStructureService) {
		_payStructureService = payStructureService;
	}

	private PayStructureService _payStructureService;

}