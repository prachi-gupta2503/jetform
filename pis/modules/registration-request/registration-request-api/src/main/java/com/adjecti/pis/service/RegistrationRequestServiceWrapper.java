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

package com.adjecti.pis.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestService
 * @generated
 */
public class RegistrationRequestServiceWrapper
	implements RegistrationRequestService,
			   ServiceWrapper<RegistrationRequestService> {

	public RegistrationRequestServiceWrapper(
		RegistrationRequestService registrationRequestService) {

		_registrationRequestService = registrationRequestService;
	}

	@Override
	public com.liferay.portal.kernel.model.User createAppUser(
		long requestId, long employeeId) {

		return _registrationRequestService.createAppUser(requestId, employeeId);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee createEmployee(
		long requestId) {

		return _registrationRequestService.createEmployee(requestId);
	}

	@Override
	public String createUser(long registrationRequestId) {
		return _registrationRequestService.createUser(registrationRequestId);
	}

	@Override
	public String createUserWithPermission(
			long registrationRequestId, boolean emailAccess,
			boolean digitalSigning, boolean eGovAccess, boolean pisAccess)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return _registrationRequestService.createUserWithPermission(
			registrationRequestId, emailAccess, digitalSigning, eGovAccess,
			pisAccess);
	}

	@Override
	public java.util.Map<String, java.util.List<String>> deduplicateLoginIds(
		String duplicateLoginIds) {

		return _registrationRequestService.deduplicateLoginIds(
			duplicateLoginIds);
	}

	@Override
	public com.adjecti.pis.model.RegistrationRequest deleteRegistrationRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestService.deleteRegistrationRequest(requestId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public RegistrationRequestService getWrappedService() {
		return _registrationRequestService;
	}

	@Override
	public void setWrappedService(
		RegistrationRequestService registrationRequestService) {

		_registrationRequestService = registrationRequestService;
	}

	private RegistrationRequestService _registrationRequestService;

}