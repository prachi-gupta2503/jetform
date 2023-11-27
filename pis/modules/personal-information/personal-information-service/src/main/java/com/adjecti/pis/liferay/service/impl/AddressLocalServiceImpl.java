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
import com.adjecti.mdm.liferay.enumeration.AccomodationTypeEnum;
import com.adjecti.pis.liferay.exception.EmployeeAddressException;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.AddressLocalServiceBaseImpl;
import com.adjecti.pis.liferay.service.validator.AddressValidator;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the address local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.AddressLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.adjecti.pis.liferay.model.Address",
		service = AopService.class
		)
public class AddressLocalServiceImpl extends AddressLocalServiceBaseImpl {

	public List<Address> addAddress(List<Address> addressDetails,long employeeId) throws EmployeeAddressException,PortalException {
		AddressValidator.validate(addressDetails, employeeId);
		AccomodationTypeEnum permanent=AccomodationTypeEnum.PARMANENT;
		AccomodationTypeEnum residence=AccomodationTypeEnum.RESIDENCE;
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		Address address=null;
		long addressId;
		long userId=serviceContext.getUserId();
		long companyId=serviceContext.getCompanyId();
		Date createDate= serviceContext.getCreateDate();
		User user=userLocalService.getUser(userId);
		long groupId=user.getGroupId();
		List<Address> addresses=new ArrayList<Address>();
		int flag=0;
		try {	
			for(Address addressDetail:addressDetails) {
				if(addressDetail.getAddressId()==0) {
					addressId=CounterLocalServiceUtil.increment(Address.class.getName());
					address=	addressPersistence.create(addressId);
				}else {
					address=	addressPersistence.findByPrimaryKey(addressDetail.getAddressId());
				}
				
				address.setUserName(user.getFullName());
				address.setGroupId(groupId);
				address.setUserId(userId);
				address.setCompanyId(companyId);
				address.setCreateDate(createDate);
				address.setAddressLine1(addressDetail.getAddressLine1());
				address.setAddressLine2(addressDetail.getAddressLine2());
				address.setAddressLine3(addressDetail.getAddressLine3());
				address.setCity(addressDetail.getCity());
				address.setPinCode(addressDetail.getPinCode());
				address.setStateId(addressDetail.getStateId());
				address.setCountryId(addressDetail.getCountryId());
				address.setDistrictId(addressDetail.getDistrictId());
				address.setAddressProofId(addressDetail.getAddressProofId());
				address.setAccomodationTypeId(permanent.getAccomodationTypeCode());
				
				if(flag==1)
					address.setAccomodationTypeId(residence.getAccomodationTypeCode());
				
				flag=1;
				address= addressPersistence.update(address);
				addresses.add(address);
				EmployeeAddressLocalServiceUtil.addEmployeeAddress(employeeId, address.getAddressId());

			}
			
		} catch (PortalException e) {

			e.printStackTrace();
		}
		System.out.println(addresses.size());
		return addresses;
	}
	
public List<Address> getAccomodationTypeByAccomodationTypeId(long accomodationTypeId){
		
	
	
	
			return addressPersistence.findByAccomodationTypeId(accomodationTypeId);
	}
	
	
	
	public List<Address> getAddressesByJoiningProcessId(long joiningProcessId){
		
		return addressPersistence.findByJoiningProcessId(joiningProcessId);
	}
	
	public List<Address> getAddressesByJoiningProcessIdAndAccomodationTypeId(long joiningProcessId, long accomodationTypeId){
		return addressPersistence.findByJoiningProcessIdAndAccomodationTypeId(joiningProcessId, accomodationTypeId);
	}
	
	public List<Address> getByDistrictId(long districtId){
		return addressPersistence.findByDistrictId(districtId);
	}
	
	public List<Address> getByStateId(long stateID){
		return addressPersistence.findByStateId(stateID);
	}
	
	public List<Address> getByAddressId(long addressId){
		return addressPersistence.findByAddressId(addressId);
	}
}