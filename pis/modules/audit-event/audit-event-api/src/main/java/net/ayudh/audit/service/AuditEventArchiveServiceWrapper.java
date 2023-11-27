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

package net.ayudh.audit.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AuditEventArchiveService}.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventArchiveService
 * @generated
 */
public class AuditEventArchiveServiceWrapper
	implements AuditEventArchiveService,
			   ServiceWrapper<AuditEventArchiveService> {

	public AuditEventArchiveServiceWrapper(
		AuditEventArchiveService auditEventArchiveService) {

		_auditEventArchiveService = auditEventArchiveService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _auditEventArchiveService.getOSGiServiceIdentifier();
	}

	@Override
	public AuditEventArchiveService getWrappedService() {
		return _auditEventArchiveService;
	}

	@Override
	public void setWrappedService(
		AuditEventArchiveService auditEventArchiveService) {

		_auditEventArchiveService = auditEventArchiveService;
	}

	private AuditEventArchiveService _auditEventArchiveService;

}