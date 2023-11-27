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


import com.adjecti.pis.liferay.exception.NoSuchEmployeePermissionException;
import com.adjecti.pis.liferay.model.EmployeePermission;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.service.EmployeePermissionLocalServiceUtil;
import com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil;
import com.adjecti.pis.liferay.service.SingleUserOnboardingLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.EmployeePermissionLocalServiceBaseImpl;
import com.adjecti.pis.model.RegistrationRequest;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee permission local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeePermissionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePermissionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeePermission",
	service = AopService.class
)
public class EmployeePermissionLocalServiceImpl
	extends EmployeePermissionLocalServiceBaseImpl {
	
	final static Log LOGGER = LogFactoryUtil.getLog(EmployeePermissionLocalServiceImpl.class.getName());

	public List<EmployeePermission> getEmployeePermissionsByJoiningProcessId(long joiningProcessId){
		return employeePermissionPersistence.findByJoiningProcessId(joiningProcessId);
	}
	public EmployeePermission getEmployeePermissionsBySingleUserOnboardingId(long singleUserOnboardingId) throws NoSuchEmployeePermissionException{
		return employeePermissionPersistence.findBySingleUserOnboardingId(singleUserOnboardingId);
	}
	public EmployeePermission getEmployeePermissionsByRegistrationRequestId(long registrationRequestId) throws NoSuchEmployeePermissionException{
		return employeePermissionPersistence.findByRegistrationRequestId(registrationRequestId);
	}
	public List<EmployeePermission> getEmployeePermissionsByFormClassName(String formName){
		return employeePermissionPersistence.findByFormClassName(formName);
	}
	
	public Object updatePermission(long employeePermissionId,boolean emailAccess,boolean digitalSigning,boolean eGovAccess,boolean pisAccess) throws PortalException {
		EmployeePermission employeePermission = EmployeePermissionLocalServiceUtil.getEmployeePermission(employeePermissionId);
		employeePermission.setDigitalSigning(digitalSigning);
		employeePermission.setEGovAccess(eGovAccess);
		employeePermission.setEmailAccess(emailAccess);
		employeePermission.setPisAccess(pisAccess);
		employeePermission.setIdamUser(true);
		EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
		
		if(employeePermission.getSingleUserOnboardingId()>0 && employeePermission.getForm().equalsIgnoreCase("SingleUserOnboarding")) {
			SingleUserOnboarding singleUserOnboarding = SingleUserOnboardingLocalServiceUtil.getSingleUserOnboarding(employeePermission.getSingleUserOnboardingId());
			singleUserOnboarding.setEGovAccess(eGovAccess);
			singleUserOnboarding.setEmailAccess(emailAccess);
			singleUserOnboarding.setDigitalSigning(digitalSigning);
			singleUserOnboarding.setPisAccess(pisAccess);
			singleUserOnboarding.setIdamUser(true);
			SingleUserOnboardingLocalServiceUtil.updateSingleUserOnboarding(singleUserOnboarding);
			return singleUserOnboarding;
		} else if (employeePermission.getJoiningProcessId()>0 && employeePermission.getForm().equalsIgnoreCase("New Joining")) {
			JoiningProcess joiningProcess = JoiningProcessLocalServiceUtil.getJoiningProcess(employeePermission.getJoiningProcessId());
			joiningProcess.setReason("");
			JoiningProcessLocalServiceUtil.updateJoiningProcess(joiningProcess);
			return joiningProcess;
			
		}
		 return employeePermission;
		}
	
}