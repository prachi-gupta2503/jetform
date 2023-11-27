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
 * Provides a wrapper for {@link QualificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see QualificationService
 * @generated
 */
public class QualificationServiceWrapper
	implements QualificationService, ServiceWrapper<QualificationService> {

	public QualificationServiceWrapper(
		QualificationService qualificationService) {

		_qualificationService = qualificationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _qualificationService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Qualification>
		getQualifications() {

		return _qualificationService.getQualifications();
	}

	@Override
	public QualificationService getWrappedService() {
		return _qualificationService;
	}

	@Override
	public void setWrappedService(QualificationService qualificationService) {
		_qualificationService = qualificationService;
	}

	private QualificationService _qualificationService;

}