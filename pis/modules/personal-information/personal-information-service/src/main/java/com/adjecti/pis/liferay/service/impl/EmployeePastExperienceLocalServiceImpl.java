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

import com.adjecti.pis.liferay.exception.EmployeePastExperienceException;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeExperience;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.service.base.EmployeePastExperienceLocalServiceBaseImpl;
import com.adjecti.pis.liferay.service.validator.EmployeePastExperienceValidator;
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
 * The implementation of the employee past experience local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeePastExperienceLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePastExperienceLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeePastExperience", service = AopService.class)
public class EmployeePastExperienceLocalServiceImpl extends EmployeePastExperienceLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeePastExperienceLocalServiceImpl.class.getName());

	public List<EmployeePastExperience> addPastExperiences(List<EmployeePastExperience> employeeExperiences)
			throws EmployeePastExperienceException, PortalException {

		EmployeePastExperienceValidator.validate(employeeExperiences);

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		long employeeExperienceId = 0;
		EmployeePastExperience employeeExp = null;
		List<EmployeePastExperience> employeePastExperiences = new ArrayList<EmployeePastExperience>();
		for (EmployeePastExperience employeeExperience : employeeExperiences) {

			if (employeeExperience.getEmployeePastExperienceId() == 0) {
				employeeExperienceId = counterLocalService.increment(EmployeePastExperience.class.getName());
				employeeExp = employeePastExperienceLocalService.createEmployeePastExperience(employeeExperienceId);
			} else {
				employeeExp = employeePastExperiencePersistence
						.findByPrimaryKey(employeeExperience.getEmployeePastExperienceId());
				employeeExperienceId = employeeExp.getEmployeePastExperienceId();
			}

			employeeExp.setEmployeePastExperienceId(employeeExperienceId);
			employeeExp.setCompanyId(companyId);
			employeeExp.setUserId(userId);
			employeeExp.setGroupId(groupId);
			employeeExp.setUserName(user.getFullName());
			employeeExp.setDesignation(employeeExperience.getDesignation());
			employeeExp.setEmployeePastExperienceId(employeeExperienceId);
			employeeExp.setFromDate(employeeExperience.getFromDate());
			employeeExp.setExperienceLetterId(employeeExperience.getExperienceLetterId());
			employeeExp.setToDate(employeeExperience.getToDate());
			employeeExp.setOrganization(employeeExperience.getOrganization());
			employeeExp.setWorkAreaId(employeeExperience.getWorkAreaId());
			employeeExp.setEmployeeId(employeeExperience.getEmployeeId());

			employeeExp = employeePastExperiencePersistence.update(employeeExp);

			employeePastExperiences.add(employeeExp);
		}
		return employeePastExperiences;
	}

	public List<EmployeePastExperience> getByEmployeeId(long employeeId) {
		
		return employeePastExperiencePersistence.findByEmployeeId(employeeId);
	}

	public List<EmployeePastExperience> getByPersonalNo(String personalNo) {
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if (employee != null) {
				return employeePastExperiencePersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;

	}
	public List<EmployeePastExperience> getEmployeePastExperiencesByJoiningProcessId(long joiningProcessId){
		return employeePastExperiencePersistence.findByJoiningProcessId(joiningProcessId);
	}
	
	public List<EmployeePastExperience> getByWorkAreaMajorId(long workAreaMajorId) {
		return employeePastExperiencePersistence.findByWorkAreaId(workAreaMajorId);
	}
}