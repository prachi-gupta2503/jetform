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
 * Provides a wrapper for {@link DesignationService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationService
 * @generated
 */
public class DesignationServiceWrapper
	implements DesignationService, ServiceWrapper<DesignationService> {

	public DesignationServiceWrapper(DesignationService designationService) {
		_designationService = designationService;
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignations() {

		return _designationService.getDesignations();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByCadreId(long cadreId) {

		return _designationService.getDesignationsByCadreId(cadreId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationClassId(long designationClassId) {

		return _designationService.getDesignationsByDesignationClassId(
			designationClassId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByDesignationGroupId(long designationGroupId) {

		return _designationService.getDesignationsByDesignationGroupId(
			designationGroupId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Designation>
		getDesignationsByGradeId(long gradeId) {

		return _designationService.getDesignationsByGradeId(gradeId);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Grade getGradesByDesignationId(
		long designationId) {

		return _designationService.getGradesByDesignationId(designationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationService.getOSGiServiceIdentifier();
	}

	@Override
	public DesignationService getWrappedService() {
		return _designationService;
	}

	@Override
	public void setWrappedService(DesignationService designationService) {
		_designationService = designationService;
	}

	private DesignationService _designationService;

}