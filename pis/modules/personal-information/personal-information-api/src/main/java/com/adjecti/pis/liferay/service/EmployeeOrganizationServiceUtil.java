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
 * Provides the remote service utility for EmployeeOrganization. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeOrganizationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationService
 * @generated
 */
public class EmployeeOrganizationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeOrganizationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean existsEmployeeOrganization(
		long employeeId, long organizationId) {

		return getService().existsEmployeeOrganization(
			employeeId, organizationId);
	}

	public static boolean existsEmployeeSubOrganization(
		long employeeId, long subOrganizationId) {

		return getService().existsEmployeeSubOrganization(
			employeeId, subOrganizationId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getByEmployeeIdAndOrganizationId(
				long employeeId, long organizationId) {

		return getService().getByEmployeeIdAndOrganizationId(
			employeeId, organizationId);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getNonAssignedOrganizationsOfEmployee(
			long parentId, String type, long employeeId) {

		return getService().getNonAssignedOrganizationsOfEmployee(
			parentId, type, employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static String updateOrganization(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return getService().updateOrganization(
			themeDisplay, status, organizationId);
	}

	public static EmployeeOrganizationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeOrganizationService, EmployeeOrganizationService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeOrganizationService.class);

		ServiceTracker<EmployeeOrganizationService, EmployeeOrganizationService>
			serviceTracker =
				new ServiceTracker
					<EmployeeOrganizationService, EmployeeOrganizationService>(
						bundle.getBundleContext(),
						EmployeeOrganizationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}