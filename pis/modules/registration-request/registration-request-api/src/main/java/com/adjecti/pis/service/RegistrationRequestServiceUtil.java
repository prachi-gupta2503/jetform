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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for RegistrationRequest. This utility wraps
 * <code>com.adjecti.pis.service.impl.RegistrationRequestServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestService
 * @generated
 */
public class RegistrationRequestServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.service.impl.RegistrationRequestServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User createAppUser(
		long requestId, long employeeId) {

		return getService().createAppUser(requestId, employeeId);
	}

	public static com.adjecti.pis.liferay.model.Employee createEmployee(
		long requestId) {

		return getService().createEmployee(requestId);
	}

	public static String createUser(long registrationRequestId) {
		return getService().createUser(registrationRequestId);
	}

	public static String createUserWithPermission(
			long registrationRequestId, boolean emailAccess,
			boolean digitalSigning, boolean eGovAccess, boolean pisAccess)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getService().createUserWithPermission(
			registrationRequestId, emailAccess, digitalSigning, eGovAccess,
			pisAccess);
	}

	public static java.util.Map<String, java.util.List<String>>
		deduplicateLoginIds(String duplicateLoginIds) {

		return getService().deduplicateLoginIds(duplicateLoginIds);
	}

	public static com.adjecti.pis.model.RegistrationRequest
			deleteRegistrationRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRegistrationRequest(requestId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static RegistrationRequestService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegistrationRequestService, RegistrationRequestService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RegistrationRequestService.class);

		ServiceTracker<RegistrationRequestService, RegistrationRequestService>
			serviceTracker =
				new ServiceTracker
					<RegistrationRequestService, RegistrationRequestService>(
						bundle.getBundleContext(),
						RegistrationRequestService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}