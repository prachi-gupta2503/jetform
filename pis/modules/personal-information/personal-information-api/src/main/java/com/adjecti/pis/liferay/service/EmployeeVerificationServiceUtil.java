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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for EmployeeVerification. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeVerificationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeVerificationService
 * @generated
 */
public class EmployeeVerificationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeVerificationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeVerification>
				addEmployeeVerifications(
					java.util.List
						<com.adjecti.pis.liferay.model.EmployeeVerification>
							employeeVerifications)
			throws com.adjecti.pis.liferay.exception.EmployeeAddressException,
				   com.liferay.portal.kernel.exception.PortalException {

		return getService().addEmployeeVerifications(employeeVerifications);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeVerification> getByPersonalNo(
			String personalNo) {

		return getService().getByPersonalNo(personalNo);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeVerification>
			getEmployeeVerificationByEmployeeId(long employeeId) {

		return getService().getEmployeeVerificationByEmployeeId(employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static EmployeeVerificationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeVerificationService, EmployeeVerificationService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeVerificationService.class);

		ServiceTracker<EmployeeVerificationService, EmployeeVerificationService>
			serviceTracker =
				new ServiceTracker
					<EmployeeVerificationService, EmployeeVerificationService>(
						bundle.getBundleContext(),
						EmployeeVerificationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}