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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeContactException;
import com.adjecti.pis.liferay.model.EmployeeContact;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for EmployeeContact. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EmployeeContactService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeContactServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the employee contact remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EmployeeContactServiceUtil} if injection and service tracking are not available.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeContact getByPersonalNo(String personalNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EmployeeContact getEmployeeContactByEmployeeId(long employeeId)
		throws NoSuchEmployeeContactException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EmployeeContact> getEmployeeContactsByEmployeeId(
			long employeeId)
		throws NoSuchEmployeeContactException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}