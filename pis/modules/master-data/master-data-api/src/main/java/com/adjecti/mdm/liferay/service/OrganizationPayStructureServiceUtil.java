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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for OrganizationPayStructure. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.OrganizationPayStructureServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationPayStructureService
 * @generated
 */
public class OrganizationPayStructureServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.OrganizationPayStructureServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static OrganizationPayStructureService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationPayStructureService, OrganizationPayStructureService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationPayStructureService.class);

		ServiceTracker
			<OrganizationPayStructureService, OrganizationPayStructureService>
				serviceTracker =
					new ServiceTracker
						<OrganizationPayStructureService,
						 OrganizationPayStructureService>(
							 bundle.getBundleContext(),
							 OrganizationPayStructureService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}