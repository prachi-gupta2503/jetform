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

package com.adjecti.pis.service.impl;

import com.adjecti.pis.exception.NoSuchRegistrationRequestException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.base.RegistrationRequestServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the registration request remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.service.RegistrationRequestService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=ofb",
		"json.web.service.context.path=RegistrationRequest"
	},
	service = AopService.class
)
public class RegistrationRequestServiceImpl
	extends RegistrationRequestServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.adjecti.pis.service.RegistrationRequestServiceUtil</code> to access the registration request remote service.
	 */
	
	public String createUser(long registrationRequestId) {
		return registrationRequestLocalService.createUser(registrationRequestId);
	}
	
	public RegistrationRequest deleteRegistrationRequest(long requestId) throws PortalException {
		return registrationRequestLocalService.deleteRegistrationRequest(requestId);
	}
	public Map<String, List<String>> deduplicateLoginIds(String duplicateLoginIds) {
		return registrationRequestLocalService.deduplicateLoginIds(duplicateLoginIds);
	}
	
	public Employee createEmployee(long requestId) {
		return registrationRequestLocalService.createEmployee(requestId);
	}
	public User createAppUser(long requestId,long employeeId) {
		return registrationRequestLocalService.createAppUser(requestId,employeeId);
	}
	public String createUserWithPermission(long registrationRequestId,boolean emailAccess,boolean digitalSigning,boolean eGovAccess,boolean pisAccess) throws NoSuchRegistrationRequestException {
		return registrationRequestLocalService.createUserWithPermission(registrationRequestId, emailAccess, digitalSigning, eGovAccess, pisAccess);
	}
}