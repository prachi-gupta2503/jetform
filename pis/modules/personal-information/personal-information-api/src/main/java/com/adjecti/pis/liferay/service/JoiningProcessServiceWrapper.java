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
 * Provides a wrapper for {@link JoiningProcessService}.
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessService
 * @generated
 */
public class JoiningProcessServiceWrapper
	implements JoiningProcessService, ServiceWrapper<JoiningProcessService> {

	public JoiningProcessServiceWrapper(
		JoiningProcessService joiningProcessService) {

		_joiningProcessService = joiningProcessService;
	}

	@Override
	public int currentStatusByJoiningProcessId(long joiningProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessService.currentStatusByJoiningProcessId(
			joiningProcessId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _joiningProcessService.getOSGiServiceIdentifier();
	}

	@Override
	public String updateStatusByJoiningProcessId(
			long joiningProcessId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessService.updateStatusByJoiningProcessId(
			joiningProcessId, status);
	}

	@Override
	public JoiningProcessService getWrappedService() {
		return _joiningProcessService;
	}

	@Override
	public void setWrappedService(JoiningProcessService joiningProcessService) {
		_joiningProcessService = joiningProcessService;
	}

	private JoiningProcessService _joiningProcessService;

}