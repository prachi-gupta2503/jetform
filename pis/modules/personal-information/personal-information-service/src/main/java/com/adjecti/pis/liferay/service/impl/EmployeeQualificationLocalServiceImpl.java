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

import com.adjecti.pis.liferay.exception.EmployeeQualificationException;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.service.base.EmployeeQualificationLocalServiceBaseImpl;
import com.adjecti.pis.liferay.service.validator.EmployeeQualificationValidator;
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
 * The implementation of the employee qualification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeQualificationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualificationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeQualification", service = AopService.class)
public class EmployeeQualificationLocalServiceImpl extends EmployeeQualificationLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeQualificationLocalServiceImpl.class.getName());

	public List<EmployeeQualification> getEmployeeQualificationByEmployeeId(long employeeId) {
		return employeeQualificationPersistence.findByEmployeeId(employeeId);
	}

	public List<EmployeeQualification> getEmployeeQualificationByPersonalNo(String personalNo) {
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if (employee != null) {
				return employeeQualificationPersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
	}

	public List<EmployeeQualification> addEmployeeQualification(List<EmployeeQualification> empQualification)
			throws PortalException, EmployeeQualificationException {

		EmployeeQualificationValidator.validate(empQualification);
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		long employeeQualificationId = 0;
		EmployeeQualification employeeQual = null;
		List<EmployeeQualification> employeeQualifications = new ArrayList<EmployeeQualification>();
		for (EmployeeQualification employeeQualification : empQualification) {

			if (employeeQualification.getEmployeeQualificationId() == 0) {
				employeeQualificationId = counterLocalService.increment(EmployeeQualification.class.getName());
				employeeQual = employeeQualificationLocalService.createEmployeeQualification(employeeQualificationId);
			} else {
				employeeQual = employeeQualificationPersistence
						.findByPrimaryKey(employeeQualification.getEmployeeQualificationId());
				employeeQualificationId = employeeQualification.getEmployeeQualificationId();
			}

			employeeQual.setEmployeeQualificationId(employeeQualificationId);
			employeeQual.setQualificationId(employeeQualification.getQualificationId());
			employeeQual.setUserId(userId);
			employeeQual.setUserName(user.getFullName());
			employeeQual.setCompanyId(companyId);
			employeeQual.setGroupId(groupId);
			employeeQual.setLevelId(employeeQualification.getLevelId());
			employeeQual.setSpecializationId(employeeQualification.getSpecializationId());
			employeeQual.setGradeId(employeeQualification.getGradeId());
			employeeQual.setForeignDegree(employeeQualification.getForeignDegree());

			employeeQual.setForeignInstitution(employeeQualification.getForeignInstitution());

			employeeQual.setFromYear(employeeQualification.getFromYear());

			employeeQual.setToYear(employeeQualification.getToYear());

			employeeQual.setQualificationDate(employeeQualification.getQualificationDate());

			employeeQual.setMarksPercentage(employeeQualification.getMarksPercentage());

			employeeQual.setCertificateId(employeeQualification.getCertificateId());

			employeeQual.setEmployeeId(employeeQualification.getEmployeeId());
			employeeQual = employeeQualificationPersistence.update(employeeQual);
			employeeQualifications.add(employeeQual);
		}
		return employeeQualifications;
	}
	
	public int getEmployeeQualificationCountByEmployeeId(long employeeId) {
		return employeeQualificationPersistence.countByEmployeeId(employeeId);
	}
	
	public int getEmployeeQualificationCountByQualificationId(long qualificationId) {
		return employeeQualificationPersistence.countByQualificationId(qualificationId);
	}
	public List<EmployeeQualification> getEmployeeQualificationsByJoiningProcessId(long joiningProcessId){
		return employeeQualificationPersistence.findByJoiningProcessId(joiningProcessId);
	}
	
	public int getEmployeeQualificationCountBySpecializationId(long specializationId) {
		return employeeQualificationPersistence.countBySpecializationId(specializationId);
	}
	
	public List<EmployeeQualification> getEmployeeQualificationsByQualificationLevelId(long qualificationLevelId){
		return employeeQualificationPersistence.findByQualificationLevelId(qualificationLevelId);
	}
	
}