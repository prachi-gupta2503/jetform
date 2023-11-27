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
 * Provides a wrapper for {@link FormDefinitionService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormDefinitionService
 * @generated
 */
public class FormDefinitionServiceWrapper
	implements FormDefinitionService, ServiceWrapper<FormDefinitionService> {

	public FormDefinitionServiceWrapper(
		FormDefinitionService formDefinitionService) {

		_formDefinitionService = formDefinitionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formDefinitionService.getOSGiServiceIdentifier();
	}

	@Override
	public FormDefinitionService getWrappedService() {
		return _formDefinitionService;
	}

	@Override
	public void setWrappedService(FormDefinitionService formDefinitionService) {
		_formDefinitionService = formDefinitionService;
	}

	private FormDefinitionService _formDefinitionService;

}