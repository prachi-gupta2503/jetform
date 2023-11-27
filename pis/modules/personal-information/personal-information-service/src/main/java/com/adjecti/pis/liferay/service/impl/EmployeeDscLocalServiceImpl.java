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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.EmployeeDsc;
import com.adjecti.pis.liferay.service.base.EmployeeDscLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee dsc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeDscLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDscLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeDsc", service = AopService.class)
public class EmployeeDscLocalServiceImpl extends EmployeeDscLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.adjecti.pis.liferay.service.EmployeeDscLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.adjecti.pis.liferay.service.EmployeeDscLocalServiceUtil</code>.
	 */
	public EmployeeDsc update(EmployeeDsc employeeDsc) throws PortalException {
		long employeeDscId=0;
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		long userId=serviceContext.getUserId();
		long companyId=serviceContext.getCompanyId();
		Date createDate= serviceContext.getCreateDate();
		User user=userLocalService.getUser(userId);
		long groupId=user.getGroupId();
		EmployeeDsc employeeDscUpdate=null;
		if(employeeDsc.getEmployeeDscId()==0) {
			employeeDscId=CounterLocalServiceUtil.increment(EmployeeDsc.class.getName());
			employeeDscUpdate=	employeeDscPersistence.create(employeeDscId);
		}else {
			employeeDscUpdate=	employeeDscPersistence.findByPrimaryKey(employeeDsc.getEmployeeDscId());
		}
		
		employeeDscUpdate.setUserName(user.getFullName());
		employeeDscUpdate.setGroupId(groupId);
		employeeDscUpdate.setUserId(userId);
		employeeDscUpdate.setCompanyId(companyId);
		employeeDscUpdate.setCreateDate(createDate);
		
		employeeDscUpdate.setOfbDSCReissueStatus(employeeDsc.getOfbDSCReissueStatus());
		employeeDscUpdate.setOfbDSCRevocationStatus(employeeDsc.getOfbDSCRevocationStatus());
		employeeDscUpdate.setEmployeeId(employeeDsc.getEmployeeId());
		employeeDsc=employeeDscPersistence.update(employeeDscUpdate);
		return employeeDsc;
	}
	public boolean isDscRevokeable(long employeeId) {
		EmployeeDsc employeeDsc = getEmployeeDscByEmployeeId(employeeId);
		if (employeeDsc == null) {
			return true;
		}

		Date reIssuDate = employeeDsc.getOfbDSCReissueDate();
		long reissueDays = getRevokedOrReissuedDays(reIssuDate);
		if (!employeeDsc.getOfbDSCRevocationStatus()) {

			if (reissueDays >= 1) {
				return true;
			}
		}
		if (employeeDsc.getOfbDSCReissueStatus() && employeeDsc.getOfbDSCRevocationStatus() && reissueDays >= 1) {
			return true;
		}
		return false;
	}

	public boolean isDscReissueable(long employeeId) {

		EmployeeDsc employeeDsc = getEmployeeDscByEmployeeId(employeeId);
		if (employeeDsc == null) {
			return false;
		}

		Date revokeDate = employeeDsc.getOfbDSCRevocationDate();
		long revokedDays = getRevokedOrReissuedDays(revokeDate);
		if (!employeeDsc.getOfbDSCReissueStatus()) {
			if (revokedDays >= 1) {
				return true;
			}
		}
		return false;
	}

	private long getRevokedOrReissuedDays(Date date) {
		Date todayDate = new Date();
		long days = 0;
		if (date != null) {
			long timediff = todayDate.getTime() - date.getTime();
			days = (timediff / (1000 * 60 * 60 * 24)) % 365;
		}
		return days;
	}

	public EmployeeDsc getEmployeeDscByEmployeeId(long employeeId) {
		List<EmployeeDsc> employeeDscs = employeeDscPersistence.findByEmployeeId(employeeId);
		if (!employeeDscs.isEmpty()) {
			return employeeDscs.get(0);
		}
		return null;
	}

}