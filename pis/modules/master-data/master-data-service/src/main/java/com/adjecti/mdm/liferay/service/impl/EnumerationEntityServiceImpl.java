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

package com.adjecti.mdm.liferay.service.impl;

import com.adjecti.jetform.model.KeyValue;
import com.adjecti.mdm.liferay.enumeration.AccomodationTypeEnum;
import com.adjecti.mdm.liferay.enumeration.model.AccomodationType;
import com.adjecti.mdm.liferay.enumeration.model.BloodGroup;
import com.adjecti.mdm.liferay.enumeration.model.CasteCategory;
import com.adjecti.mdm.liferay.enumeration.model.Gender;
import com.adjecti.mdm.liferay.enumeration.model.MaritalStatus;
import com.adjecti.mdm.liferay.service.base.EnumerationEntityServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the enumeration entity remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.EnumerationEntityService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EnumerationEntityServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=mdm",
		"json.web.service.context.path=EnumerationEntity"
	},
	service = AopService.class
)
public class EnumerationEntityServiceImpl
	extends EnumerationEntityServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.adjecti.mdm.liferay.service.EnumerationEntityServiceUtil</code> to access the enumeration entity remote service.
	 */
	final static String[] GENDER= {"Male","Female","Transgender"};
	final static String[] ACCOMODATIONTYPE= {"Parmanent","Residence"};
	final static String[] BLOODGROUP= {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
	final static String[] CASTECATEGORY= {"Gernal","OBC","SC","ST"};
	final static String[] MARITALSTATUS= {"Married","Unmarried","Divorced","Widowed"};
	
	public Gender getGender(int genderId) {
		return new Gender(genderId,GENDER[genderId-1]);
	}
	public List<Gender> getGenders(){
		int index=0;
		List<Gender> genderList=new ArrayList<Gender>();
		for(String gender:GENDER) {
			index++;
			genderList.add(new Gender(index,gender));
			
		}
		return genderList;
	}
	
	
	public AccomodationType getAccomodationType(int accomodationTypeId) {
		return new AccomodationType(accomodationTypeId,ACCOMODATIONTYPE[accomodationTypeId-1]);
	}
	public List<AccomodationType> getAccomodationTypes(){
		int index=0;
		List<AccomodationType> accomodationTypeList=new ArrayList<AccomodationType>();
		for(String accomodationType:ACCOMODATIONTYPE) {
			index++;
			accomodationTypeList.add(new AccomodationType(index,accomodationType));
			
		}
		return accomodationTypeList;
	}
	
	
	
	
	public BloodGroup getBloodGroup(int bloodGroupId) {
		return new BloodGroup(bloodGroupId,BLOODGROUP[bloodGroupId-1]);
	}
	public List<BloodGroup> getBloodGroups(){
		int index=0;
		List<BloodGroup> bloodGroupList=new ArrayList<BloodGroup>();
		for(String bloodGroup:BLOODGROUP) {
			index++;
			bloodGroupList.add(new BloodGroup(index,bloodGroup));
			
		}
		return bloodGroupList;
	}
	
	
	
	
	public MaritalStatus getMaritalStatus(int maritalStatusId) {
		return new MaritalStatus(maritalStatusId,MARITALSTATUS[maritalStatusId-1]);
	}
	public List<MaritalStatus> getMaritalStatuses(){
		int index=0;
		List<MaritalStatus> maritalStatusList=new ArrayList<MaritalStatus>();
		for(String maritalStatus:MARITALSTATUS) {
			index++; 
			maritalStatusList.add(new MaritalStatus(index,maritalStatus));
		}
		return maritalStatusList;
	}
	
	
	
	public CasteCategory getCasteCategory(int casteCategoryId) {
		return new CasteCategory(casteCategoryId,CASTECATEGORY[casteCategoryId-1]);
	}
	public List<CasteCategory> getCasteCategorys(){
		int index=0;
		List<CasteCategory> casteCategoryList=new ArrayList<CasteCategory>();
		for(String casteCategory:CASTECATEGORY) {
			index++;
			casteCategoryList.add(new CasteCategory(index,casteCategory));
		}
		return casteCategoryList;
	}
	
}