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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeDocumentService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentService
 * @generated
 */
public class EmployeeDocumentServiceWrapper
	implements EmployeeDocumentService,
			   ServiceWrapper<EmployeeDocumentService> {

	public EmployeeDocumentServiceWrapper(
		EmployeeDocumentService employeeDocumentService) {

		_employeeDocumentService = employeeDocumentService;
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
			addEmployeeDocument(
				java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
					employeeDocument)
		throws com.adjecti.pis.liferay.exception.EmployeeDocumentException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeDocumentService.addEmployeeDocument(employeeDocument);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
		getByPersonalNo(String personalNo) {

		return _employeeDocumentService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDocument>
		getEmployeeDocumentByEmpId(long employeeId) {

		return _employeeDocumentService.getEmployeeDocumentByEmpId(employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDocumentService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeDocumentService getWrappedService() {
		return _employeeDocumentService;
	}

	@Override
	public void setWrappedService(
		EmployeeDocumentService employeeDocumentService) {

		_employeeDocumentService = employeeDocumentService;
	}

	private EmployeeDocumentService _employeeDocumentService;

}