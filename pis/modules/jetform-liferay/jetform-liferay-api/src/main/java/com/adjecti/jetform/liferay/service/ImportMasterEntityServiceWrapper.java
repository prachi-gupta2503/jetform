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

package com.adjecti.jetform.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImportMasterEntityService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMasterEntityService
 * @generated
 */
public class ImportMasterEntityServiceWrapper
	implements ImportMasterEntityService,
			   ServiceWrapper<ImportMasterEntityService> {

	public ImportMasterEntityServiceWrapper(
		ImportMasterEntityService importMasterEntityService) {

		_importMasterEntityService = importMasterEntityService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _importMasterEntityService.getOSGiServiceIdentifier();
	}

	@Override
	public ImportMasterEntityService getWrappedService() {
		return _importMasterEntityService;
	}

	@Override
	public void setWrappedService(
		ImportMasterEntityService importMasterEntityService) {

		_importMasterEntityService = importMasterEntityService;
	}

	private ImportMasterEntityService _importMasterEntityService;

}