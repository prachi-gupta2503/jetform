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
 * Provides the remote service utility for Designation. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.DesignationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationService
 * @generated
 */
public class DesignationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.DesignationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignations() {

		return getService().getDesignations();
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByCadreId(long cadreId) {

		return getService().getDesignationsByCadreId(cadreId);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationClassId(long designationClassId) {

		return getService().getDesignationsByDesignationClassId(
			designationClassId);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationGroupId(long designationGroupId) {

		return getService().getDesignationsByDesignationGroupId(
			designationGroupId);
	}

	public static java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByGradeId(long gradeId) {

		return getService().getDesignationsByGradeId(gradeId);
	}

	public static com.adjecti.mdm.liferay.model.Grade getGradesByDesignationId(
		long designationId) {

		return getService().getGradesByDesignationId(designationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DesignationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DesignationService, DesignationService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DesignationService.class);

		ServiceTracker<DesignationService, DesignationService> serviceTracker =
			new ServiceTracker<DesignationService, DesignationService>(
				bundle.getBundleContext(), DesignationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}