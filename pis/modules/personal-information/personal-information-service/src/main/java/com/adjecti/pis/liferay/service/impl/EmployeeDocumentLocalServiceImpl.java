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

import com.adjecti.pis.liferay.exception.EmployeeDocumentException;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeDocumentException;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeDocument;
import com.adjecti.pis.liferay.service.base.EmployeeDocumentLocalServiceBaseImpl;
import com.adjecti.pis.liferay.service.validator.EmployeeDocumentValidator;
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
 * The implementation of the employee document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeDocumentLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDocumentLocalServiceBaseImpl
 */

@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeDocument", service = AopService.class)
public class EmployeeDocumentLocalServiceImpl extends EmployeeDocumentLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeDocumentLocalServiceImpl.class.getName());

	public List<EmployeeDocument> addEmployeeDocument(List<EmployeeDocument> employeeDocuments)
			throws PortalException, EmployeeDocumentException {

		EmployeeDocumentValidator.validate(employeeDocuments);

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		String userName = user.getFullName();
		long companyId = user.getCompanyId();
		long groupId = user.getGroupId();
		List<EmployeeDocument> documents = new ArrayList<EmployeeDocument>();
		long employeeDocumentId = 0;
		EmployeeDocument employeeDoc = null;
		for (EmployeeDocument employeeDocument : employeeDocuments) {
			try {
				employeeDoc=employeeDocumentPersistence.findByDocumentId(employeeDocument.getDocumentId());
			} catch (NoSuchEmployeeDocumentException e) {
				// TODO Auto-generated catch block
				employeeDoc=null;
			}
			if(employeeDoc==null) {
				if (employeeDocument.getEmployeeDocumentId() == 0) {
					employeeDocumentId = counterLocalService.increment(EmployeeDocument.class.getName());

					employeeDoc = employeeDocumentPersistence.create(employeeDocumentId);
				} else {

					employeeDoc = employeeDocumentPersistence.findByPrimaryKey(employeeDocument.getEmployeeDocumentId());
					employeeDocumentId = employeeDocument.getEmployeeDocumentId();
				}
			}else {
				employeeDocumentId = employeeDocument.getEmployeeDocumentId();
			}
			

			employeeDoc.setEmployeeDocumentId(employeeDocumentId);
			employeeDoc.setDiscription(employeeDocument.getDiscription());
			employeeDoc.setDocumentId(employeeDocument.getDocumentId());
			employeeDoc.setDocumentTypeId(employeeDocument.getDocumentTypeId());
			employeeDoc.setTitle(employeeDocument.getTitle());
			employeeDoc.setUserId(userId);
			employeeDoc.setCompanyId(companyId);
			employeeDoc.setGroupId(groupId);
			employeeDoc.setUserName(userName);
			employeeDoc.setEmployeeId(employeeDocument.getEmployeeId());
			employeeDoc = employeeDocumentPersistence.update(employeeDoc);
			documents.add(employeeDoc);
		}
		return documents;
	}

	public List<EmployeeDocument> getEmployeeDocumentByEmpId(long employeeId) {
		return employeeDocumentPersistence.findByEmployeeId(employeeId);
	}

	public List<EmployeeDocument> getByPersonalNo(String personalNo) {
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if (employee != null) {
				return employeeDocumentPersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
	}

}