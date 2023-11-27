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

package net.ayudh.audit.service.impl;

import com.liferay.portal.aop.AopService;

import net.ayudh.audit.service.base.AuditEventArchiveServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the audit event archive remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>net.ayudh.audit.service.AuditEventArchiveService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventArchiveServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=audit",
		"json.web.service.context.path=AuditEventArchive"
	},
	service = AopService.class
)
public class AuditEventArchiveServiceImpl
	extends AuditEventArchiveServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>net.ayudh.audit.service.AuditEventArchiveServiceUtil</code> to access the audit event archive remote service.
	 */
}