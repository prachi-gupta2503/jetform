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

import com.adjecti.pis.liferay.exception.EmployeeJoiningException;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeeTransfer;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.EmployeeJoiningLocalServiceBaseImpl;
import com.adjecti.pis.liferay.service.persistence.EmployeeJoiningPersistence;
import com.adjecti.pis.liferay.service.validator.EmployeeJoiningValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee joining local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.EmployeeJoiningLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeJoiningLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeJoining",
	service = AopService.class
)
public class EmployeeJoiningLocalServiceImpl
	extends EmployeeJoiningLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeJoiningLocalServiceImpl.class.getName());
	
	public EmployeeJoining addEmployeeJoiningDetails(EmployeeJoining employeeJoiningData) throws PortalException, EmployeeJoiningException {
		
		EmployeeJoiningValidator.validate(employeeJoiningData);
		
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();

		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId=user.getCompanyId();
		long groupId=user.getGroupId();
		EmployeeJoining employeeJoining=null;
		
		long employeeJoiningId=0;
		if(employeeJoiningData.getEmployeeJoiningId()==0) {
			employeeJoiningId=counterLocalService.increment(EmployeeJoining.class.getName());
			employeeJoining=employeeJoiningLocalService.createEmployeeJoining(employeeJoiningId);
			
		}else {
			employeeJoiningId=employeeJoiningData.getEmployeeJoiningId();
			employeeJoining=employeeJoiningPersistence.findByPrimaryKey(employeeJoining.getEmployeeJoiningId());
		}
		if(employeeJoiningData.getEmployeeId()!=0) {
			Employee employee= EmployeeLocalServiceUtil.getEmployee(employeeJoiningData.getEmployeeId());
			employee.setEmailId(employeeJoiningData.getEmailAddress());
			employee.setDesignationId(employeeJoiningData.getDesignationId());
			employee.setGradeId(employeeJoiningData.getGradeId());
			employee.setPayLevelId(employeeJoiningData.getPayLevelId());
			employee.setTradeId(employeeJoiningData.getTradeId());
			employee.setOrganizationId(employeeJoiningData.getOrganizationId());
			employee.setGradeModeId(employeeJoiningData.getGradeModeId());
			employee.setDateOfJoining(employeeJoiningData.getDateOfJoining());
			EmployeeLocalServiceUtil.updateEmployee(employee);
			
		}
		
		employeeJoining.setEmployeeJoiningId(employeeJoiningId);
		employeeJoining.setGroupId(groupId);
		employeeJoining.setUserId(userId);
		employeeJoining.setUserName(user.getFullName());
		employeeJoining.setCompanyId(companyId);
		employeeJoining.setEmailAddress(employeeJoiningData.getEmailAddress());
		employeeJoining.setDesignationId(employeeJoiningData.getDesignationId());
		employeeJoining.setGradeId(employeeJoiningData.getGradeId());
		employeeJoining.setPayLevelId(employeeJoiningData.getPayLevelId());
		employeeJoining.setTradeId(employeeJoiningData.getTradeId());
		employeeJoining.setOrganizationId(employeeJoiningData.getOrganizationId());
		employeeJoining.setJoiningModeId(employeeJoiningData.getJoiningModeId());
		employeeJoining.setJoiningLetterId(employeeJoiningData.getJoiningLetterId());
		employeeJoining.setGradeModeId(employeeJoiningData.getGradeModeId());
		employeeJoining.setFromDate(employeeJoiningData.getFromDate());
		employeeJoining.setToDate(employeeJoiningData.getToDate());
		employeeJoining.setSelectionDate(employeeJoiningData.getSelectionDate());
		employeeJoining.setDateOfJoiningOrganization(employeeJoiningData.getDateOfJoiningOrganization());
		employeeJoining.setDateOfJoining(employeeJoiningData.getDateOfJoining());
		employeeJoining.setConfirmationDate(employeeJoiningData.getGradeConfirmationDate());
		employeeJoining.setGradeConfirmationDate(employeeJoiningData.getGradeConfirmationDate());
		employeeJoining.setGovtServiceDate(employeeJoiningData.getGovtServiceDate());
		employeeJoining.setRecruitmentBatch(employeeJoiningData.getRecruitmentBatch());
		employeeJoining.setEmployeeId(employeeJoiningData.getEmployeeId());
		
		return employeeJoiningPersistence.update(employeeJoining);
		
	}
	public List<EmployeeJoining> getJoiningByEmployeeId(long employeeId){
		return employeeJoiningPersistence.findByEmployeeId(employeeId);
	}
	
	public List<EmployeeJoining> getByPersonalNo(String personalNo)
	{
		try {
			Employee employee = employeePersistence.findByPersonalNo(personalNo);
				if(employee != null)
				{
					return employeeJoiningPersistence.findByEmployeeId(employee.getEmployeeId());
				}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
	}
	
	public List<EmployeeJoining> searchEmployeeJoining(long organizationId,long tradeId,long gradeId,long designationId){
		DynamicQuery employeeJoiningQuery =dynamicQuery();
		if(organizationId!=0) {
			employeeJoiningQuery.add(RestrictionsFactoryUtil.eq("organizationId", organizationId));
		}
		if(tradeId!=0){
			employeeJoiningQuery.add(RestrictionsFactoryUtil.eq("tradeId", tradeId));
		}
		if(gradeId!=0) {
			employeeJoiningQuery.add(RestrictionsFactoryUtil.eq("gradeId", gradeId));
		}
		if(designationId!=0) {
			employeeJoiningQuery.add(RestrictionsFactoryUtil.eq("designationId", designationId));
		}
		
		return EmployeeJoiningLocalServiceUtil.dynamicQuery(employeeJoiningQuery);
	}
	public EmployeeJoining findByjoiningProcessId(long joiningProcessId) {
		List<EmployeeJoining> EmployeeJoining = employeeJoiningPersistence.findByJoiningProcessId(joiningProcessId);
		return EmployeeJoining.get(0);
	}
public List<EmployeeJoining> getGradeModeByGradeModeId(long gradeModeId){
		return employeeJoiningPersistence.findByGradeModeId(gradeModeId);
}

public List<EmployeeJoining> findByOrganizationID(long organizationId){
	return employeeJoiningPersistence.findByOrganizationId(organizationId);
}
	
public List<EmployeeJoining> findBySubOrganizationId(long subOrganizationId){
	return employeeJoiningPersistence.findBySubOrganizationId(subOrganizationId);
}
	
}