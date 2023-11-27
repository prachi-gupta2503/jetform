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
 * Provides the remote service utility for EmployeeContact. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeContactServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactService
 * @generated
 */
public class EmployeeContactServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeContactServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.adjecti.pis.liferay.model.EmployeeContact getByPersonalNo(
		String personalNo) {

		return getService().getByPersonalNo(personalNo);
	}

	public static com.adjecti.pis.liferay.model.EmployeeContact
			getEmployeeContactByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getService().getEmployeeContactByEmployeeId(employeeId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeContact>
			getEmployeeContactsByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getService().getEmployeeContactsByEmployeeId(employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static EmployeeContactService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeContactService, EmployeeContactService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeContactService.class);

		ServiceTracker<EmployeeContactService, EmployeeContactService>
			serviceTracker =
				new ServiceTracker
					<EmployeeContactService, EmployeeContactService>(
						bundle.getBundleContext(), EmployeeContactService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}