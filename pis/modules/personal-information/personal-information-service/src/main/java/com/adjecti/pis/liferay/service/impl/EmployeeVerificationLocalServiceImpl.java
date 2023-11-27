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

import com.adjecti.pis.liferay.exception.EmployeeAddressException;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.service.base.EmployeeVerificationLocalServiceBaseImpl;
import com.adjecti.pis.liferay.service.validator.EmployeeVerificationValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee verification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeVerificationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeVerificationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeVerification",
	service = AopService.class
)
public class EmployeeVerificationLocalServiceImpl
	extends EmployeeVerificationLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeVerificationLocalServiceImpl.class.getName());
	
	public List<EmployeeVerification> addEmployeeVerifications(List<EmployeeVerification> employeeVerifications) throws PortalException, EmployeeAddressException {
		
		EmployeeVerificationValidator.validate(employeeVerifications);
		
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId=user.getCompanyId();
		long groupId=user.getGroupId();
		long employeeVerificationId=0;
		EmployeeVerification verification=null;
		List<EmployeeVerification> verifications=new ArrayList<EmployeeVerification>();
		for(EmployeeVerification employeeVerification:employeeVerifications) {
			
			if(employeeVerification.getEmployeeVerificationId()==0) {
				employeeVerificationId =counterLocalService.increment(EmployeeVerification.class.getName());
				verification=employeeVerificationLocalService.createEmployeeVerification(employeeVerificationId);
			}else {
				verification=	employeeVerificationPersistence.findByPrimaryKey(employeeVerification.getEmployeeVerificationId());
				employeeVerificationId=employeeVerification.getEmployeeVerificationId();
				
			}
			
			verification.setEmployeeVerificationId(employeeVerificationId);
			
			verification.setCompanyId(companyId);
			verification.setUserId(userId);
            verification.setGroupId(groupId);
            verification.setUserName(user.getFullName());
            verification.setDocumentNo(employeeVerification.getDocumentNo());
            verification.setVerificationTypeId(employeeVerification.getVerificationTypeId());
            verification.setVerificationDate(employeeVerification.getVerificationDate());
            verification.setAuthority(employeeVerification.getAuthority());
            verification.setRemarks(employeeVerification.getRemarks());
            verification.setDocumentId(employeeVerification.getDocumentId());
            verification.setEmployeeId(employeeVerification.getEmployeeId());
            verification=employeeVerificationPersistence.update(verification);
            verifications.add(verification);
		}
		return verifications;
	}
	
	public List<EmployeeVerification> getByEmployeeId(long employeeId){
		return employeeVerificationPersistence.findByEmployeeId(employeeId);
	}
	
	public List<EmployeeVerification> getByPersonalNo(String personalNo)
	{
		try {
			Employee employee = employeePersistence.findByPersonalNo(personalNo);
				if(employee != null)
				{
					employeeVerificationPersistence.findByEmployeeId(employee.getEmployeeId());
				}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
	}
	public List<EmployeeVerification> getEmployeeVerificationsByJoiningProcessId(long joiningProcessId){
		return employeeVerificationPersistence.findByJoiningProcessId(joiningProcessId);
	}
	public List<EmployeeVerification> getByUnitId(long organizationId){
		return employeeVerificationPersistence.findByOrganizationId(organizationId);
	}
}