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
 * Provides a wrapper for {@link QualificationLevelService}.
 *
 * @author Brian Wing Shun Chan
 * @see QualificationLevelService
 * @generated
 */
public class QualificationLevelServiceWrapper
	implements QualificationLevelService,
			   ServiceWrapper<QualificationLevelService> {

	public QualificationLevelServiceWrapper(
		QualificationLevelService qualificationLevelService) {

		_qualificationLevelService = qualificationLevelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _qualificationLevelService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.QualificationLevel>
		getQualificationLevels() {

		return _qualificationLevelService.getQualificationLevels();
	}

	@Override
	public QualificationLevelService getWrappedService() {
		return _qualificationLevelService;
	}

	@Override
	public void setWrappedService(
		QualificationLevelService qualificationLevelService) {

		_qualificationLevelService = qualificationLevelService;
	}

	private QualificationLevelService _qualificationLevelService;

}