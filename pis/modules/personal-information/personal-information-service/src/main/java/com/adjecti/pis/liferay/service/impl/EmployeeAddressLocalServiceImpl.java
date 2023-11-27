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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeException;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.service.base.EmployeeAddressLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee address local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.adjecti.pis.liferay.service.EmployeeAddressLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.adjecti.pis.liferay.model.EmployeeAddress", service = AopService.class)
public class EmployeeAddressLocalServiceImpl extends EmployeeAddressLocalServiceBaseImpl {

	private final static Log _logger = LogFactoryUtil.getLog(EmployeeAddressLocalServiceImpl.class.getName());

	public EmployeeAddress addEmployeeAddress(long employeeId, long addressId) throws PortalException {
		// TODO Auto-generated method stub
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		EmployeeAddress employeeAddress = null;
		long employeeAddressId;
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		Date createDate = serviceContext.getCreateDate();
		User user = userLocalService.getUser(userId);
		long groupId = user.getGroupId();
		String userName = UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName();
		employeeAddressId = CounterLocalServiceUtil.increment(EmployeeAddress.class.getName());
		employeeAddress = employeeAddressPersistence.create(employeeAddressId);
		employeeAddress.setUserName(userName);
		employeeAddress.setUserId(userId);
		employeeAddress.setGroupId(groupId);
		employeeAddress.setCompanyId(companyId);
		employeeAddress.setCreateDate(createDate);
		employeeAddress.setEmployeeId(employeeId);
		employeeAddress.setAddressId(addressId);
		System.out.println(employeeAddressId+" Employee "+ addressId);
		return employeeAddressPersistence.update(employeeAddress);

	}

	public void getData() {
		System.out.println("hello");
	}
	public List<EmployeeAddress> getEmployeeAddressByEmpId(long employeeId){
		return employeeAddressPersistence.findByEmployeeId(employeeId);
	}
	
	public List<EmployeeAddress> getAccomodationTypeByAccomodationTypeId(long accomodationTypeId){
		
		return employeeAddressPersistence.findByAccomodationTypeId(accomodationTypeId);
}
	
	
	
	public List<EmployeeAddress> getByPersonalNo(String personalNo) 
	{
		Employee employee;
		try {
			employee = employeePersistence.findByPersonalNo(personalNo);
			if(employee!=null)
			{
				return employeeAddressPersistence.findByEmployeeId(employee.getEmployeeId());
			}
		} catch (NoSuchEmployeeException e) {
			_logger.error(e.getMessage());
		}
		return null;
	}
public List<EmployeeAddress> getByDistrictId(long districtId){
		
		return employeeAddressPersistence.findByDistrictId(districtId);
}
public List<EmployeeAddress> getByStateId(long stateId){
	
	return employeeAddressPersistence.findByStateId(stateId);
}
}