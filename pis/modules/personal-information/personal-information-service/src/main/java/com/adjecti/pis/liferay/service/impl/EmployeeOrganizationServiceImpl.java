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

package com.adjecti.pis.liferay.service.impl;

import com.adjecti.pis.liferay.model.EmployeeOrganization;
import com.adjecti.pis.liferay.service.base.EmployeeOrganizationServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee organization remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeOrganizationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=pis",
		"json.web.service.context.path=EmployeeOrganization"
	},
	service = AopService.class
)
public class EmployeeOrganizationServiceImpl
	extends EmployeeOrganizationServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.adjecti.pis.liferay.service.EmployeeOrganizationServiceUtil</code> to access the employee organization remote service.
	 */
	
	public boolean existsEmployeeOrganization(long employeeId, long organizationId) {
		return employeeOrganizationLocalService.existsEmployeeOrganization(employeeId, organizationId);
	}
	
	public boolean existsEmployeeSubOrganization(long employeeId, long subOrganizationId) {
		return employeeOrganizationLocalService.existsEmployeeSubOrganization(employeeId, subOrganizationId);
	}
	
	public List<EmployeeOrganization> getByEmployeeIdAndOrganizationId(long employeeId, long organizationId) {
		return employeeOrganizationLocalService.getByEmployeeIdAndOrganizationId(employeeId, organizationId);
	}
	public List<Organization> getNonAssignedOrganizationsOfEmployee(long parentId,String type,long employeeId){
		return employeeOrganizationLocalService.getNonAssignedOrganizationsOfEmployee(parentId, type, employeeId);
		
	}
	public String updateOrganization(ThemeDisplay themeDisplay, String status, long organizationId) {
		return employeeOrganizationLocalService.updateOrganization(themeDisplay, status, organizationId);
	}
}