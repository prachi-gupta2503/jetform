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

import com.adjecti.common.util.DateUtils;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.service.CasteCategoryLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GenderLocalServiceUtil;
import com.adjecti.pis.liferay.exception.PeopleException;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.service.base.PeopleLocalServiceBaseImpl;
import com.adjecti.pis.liferay.service.validator.PeopleValidator;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the people local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.pis.liferay.service.PeopleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PeopleLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.pis.liferay.model.People",
	service = AopService.class
)
public class PeopleLocalServiceImpl extends PeopleLocalServiceBaseImpl {
	final static Log LOGGER = LogFactoryUtil.getLog(PeopleLocalServiceImpl.class.getName());
	public long addPeople(People person, long employeeId) throws PortalException, PeopleException {
		PeopleValidator.validate(person);
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();

		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId=user.getCompanyId();
		long groupId=user.getGroupId();
		People people=null;
		long peopleId =0;
		if(employeeId==0) {
			peopleId =counterLocalService.increment(People.class.getName());

			people=peopleLocalService.createPeople(peopleId);
		}else {
			Employee employee= EmployeeLocalServiceUtil.getEmployee(employeeId);
			peopleId =employee.getPeopleId();
			people=peoplePersistence.findByPrimaryKey(peopleId);
		}
		people.setUserName(user.getFullName());
		people.setPeopleId(peopleId);
		people.setGroupId(groupId);
		people.setUserId(userId);
		people.setCompanyId(companyId);
		people.setProfileImageId(person.getProfileImageId());
		people.setDateOfBirth(person.getDateOfBirth());
		people.setCitizenshipId(person.getCitizenshipId());
		people.setPhTypeId(person.getPhTypeId());
		people.setReligionId(person.getReligionId());
		people.setAadhaarNo(person.getAadhaarNo());
		people.setPanNo(person.getPanNo());
		people.setIdentificationMark(person.getIdentificationMark());
		people.setIdentityProofId(person.getIdentityProofId());
		people.setColor(person.getColor());
		people.setHeight(person.getHeight());
		people.setFirstName_En(person.getFirstName_En());
		people.setFirstName_Hi(person.getFirstName_Hi());
		people.setLastName_Hi(person.getLastName_Hi());
		people.setMiddleName_Hi(person.getMiddleName_Hi());
		people.setFatherName_Hi(person.getFatherName_Hi());
		people.setLastName_En(person.getLastName_En());
		people.setMiddleName_En(person.getMiddleName_En());
		people.setFatherName_En(person.getFatherName_En());
		people.setAppellationId(person.getAppellationId());
		people.setBloodGroupId(person.getBloodGroupId());
		people.setGenderId(person.getGenderId());
		people.setCasteCategoryId(person.getCasteCategoryId());
		people.setMaritalStatusId(person.getMaritalStatusId());
		people.setExServiceMan(person.getExServiceMan());
		people=peoplePersistence.update(people);
		if(employeeId==0)
			employeeId= EmployeeLocalServiceUtil.addEmployee(people.getPeopleId());
		return employeeId;
	}
	
	public People addPeople(long peopleId, long appellationId, String firstName_En, String middleName_En, String lastName_En, String firstName_Hi, String middleName_Hi, String lastName_Hi,  String fatherName_En, String fatherName_Hi, Date dateOfBirth, long genderId, long casteCategoryId, long maritalStatusId, String panNo, String aadhaarNo) throws PortalException{
		ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		long userId = serviceContext.getUserId();
		User user=null;
		try {
			user = userLocalService.getUser(userId);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if(user==null) {
			return null;
		}
		
		long companyId=user.getCompanyId();
		long groupId=user.getGroupId();
		People people=null;
		try {
			if(peopleId==0) {
				peopleId = counterLocalService.increment(People.class.getName());
				people=peopleLocalService.createPeople(peopleId);
			}else {
				people=peoplePersistence.findByPrimaryKey(peopleId);
			}
			people.setUserName(user.getFullName());
			people.setPeopleId(peopleId);
			people.setGroupId(groupId);
			people.setUserId(userId);
			people.setCompanyId(companyId);
	
			people.setAppellationId(appellationId);
			
			people.setFirstName_En(firstName_En);
			people.setFirstName_Hi(firstName_Hi);
	
			people.setMiddleName_En(middleName_En);
			people.setMiddleName_Hi(middleName_Hi);
	
			people.setLastName_En(lastName_En);
			people.setLastName_Hi(lastName_Hi);
	
			people.setFatherName_En(fatherName_En);
			people.setFatherName_Hi(fatherName_Hi);
	
			people.setDateOfBirth(dateOfBirth);
			people.setAadhaarNo(aadhaarNo);
			people.setPanNo(panNo);
	
			people.setGenderId(genderId);
			people.setCasteCategoryId(casteCategoryId);
			people.setMaritalStatusId(maritalStatusId);
			people=peoplePersistence.update(people);
		}catch(Exception e) {
			throw new PortalException(e);
		}
		return people;
	}
	
	public List<People> searchPeople(String keywords){
		
		DynamicQuery peopleQuery =dynamicQuery();
		
		if (StringUtils.isNotBlank(keywords)) {
			Disjunction disjunctionQuery =
				RestrictionsFactoryUtil.disjunction();
			
			disjunctionQuery.add(
				RestrictionsFactoryUtil.ilike("firstName_En", "%" + keywords + "%"));
			
			disjunctionQuery.add(
				RestrictionsFactoryUtil.ilike("middleName_En", "%" + keywords + "%"));
			
			disjunctionQuery.add(
					RestrictionsFactoryUtil.ilike("lastName_En", "%" + keywords + "%"));

			
			peopleQuery.add(disjunctionQuery);
		}
		
		return PeopleLocalServiceUtil.dynamicQuery(peopleQuery);
	}
	
	public List<People> getByDateOfBirth() throws PortalException {
		List<People> peoples=null;
	    Calendar today=Calendar.getInstance(Locale.getDefault());
	    today.set(Calendar.HOUR_OF_DAY, 0);
	    today.set(Calendar.MINUTE, 0);
	    today.set(Calendar.SECOND, 0);
	    today.set(Calendar.MILLISECOND, 0);
	    
	    Calendar tomorrow=Calendar.getInstance(Locale.getDefault());
	    tomorrow.add(Calendar.DAY_OF_MONTH, 1);
	    tomorrow.set(Calendar.HOUR_OF_DAY, 0);
	    tomorrow.set(Calendar.MINUTE, 0);
	    tomorrow.set(Calendar.SECOND, 0);
	    tomorrow.set(Calendar.MILLISECOND, 0);
	   
	    
	    LOGGER.info("today : "+today.getTime() +", tomorrow: "+tomorrow.getTime());

	    LocalDate time = LocalDate.now();    
	    int month = time.getMonthValue();
	    int date  = time.getDayOfMonth();
	    
	     peoples = peopleFinder.getByDateOfBirth(date, month);
		/*
		 * for(People byDateOfBirth:byDateOfBirths) {
		 * System.out.println(byDateOfBirth.getDateOfBirth()+"    "+today.getTime()); }
		 */
	    
	    
		/*
		 * try { DynamicQuery peopleQuery =dynamicQuery();
		 * peopleQuery.add(RestrictionsFactoryUtil.between("dateOfBirth",
		 * today.getTime(), tomorrow.getTime()));
		 * peoples=PeopleLocalServiceUtil.dynamicQuery(peopleQuery); } catch (Exception
		 * e) { LOGGER.error(e); }
		 */
		
		LOGGER.info("peoples : "+peoples);
		return peoples; 

	}
	public boolean beforeUpdateEmployee(Object entity, Map<String, String[]> fieldValues) {
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();
		//Employee employee=(Employee)entity;
		
		//LOGGER.info("Inside beforeUpdateEmployee(Object entity, Map<String, String[]> fieldValues) "+entity);
		//if(employee.isNew()) {
		//	return true;
		//}
		long peopleId=0;
		People people=null;
		Employee employee=null;
		try {
			peopleId=Long.parseLong(fieldValues.get("peopleId")[0].trim());
			if(peopleId>0) {
				people=peoplePersistence.findByPrimaryKey(peopleId);
			}
			if(people!=null) {
				employee=employeePersistence.findByPeopleId(peopleId);
			}
			LOGGER.info(employee);
		}catch(Exception e) {
			LOGGER.error(e);
		}

		if(people==null || employee==null) {
			return false;
		}
		
		LOGGER.info("Before dateOfBirth......");
		Date dob=null;
		
		try {
			Date oldDob=people.getDateOfBirth();
			dob=DateUtils.toDate(StringUtils.trim(fieldValues.get("dateOfBirth")[0]),DateUtils.YYYY_MM_DD) ;
			String oldDobStr=DateUtils.format(oldDob, DateUtils.YYYY_MM_DD);
			String newDobStr=DateUtils.format(dob, DateUtils.YYYY_MM_DD);
			LOGGER.info("oldDobStr : "+oldDobStr);
			LOGGER.info("newDobStr : "+newDobStr);
			if(!oldDobStr.equals(newDobStr)) {
				attributes.add("dateOfBirth");
				oldValues.add(oldDobStr);
				newValues.add(newDobStr);
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		LOGGER.info("Before Gender......");
		long genderId=0;
		
		try {
			long oldGenderId=people.getGenderId();
			LOGGER.info("oldGenderId : "+oldGenderId);
			genderId = Long.parseLong(fieldValues.get("genderId")[0]);
			LOGGER.info("newGenderId : "+genderId);
			if(oldGenderId!=0 && genderId!=0 && oldGenderId!=genderId) {
				Gender oldGender=GenderLocalServiceUtil.getGender(oldGenderId);
				Gender newGender=GenderLocalServiceUtil.getGender(genderId);
				attributes.add("gender");
				oldValues.add(oldGender.getName());
				newValues.add(newGender.getName());
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		LOGGER.info("Before CasteCategory......");
		long casteId=0;
		
		try {
			long oldCasteId=people.getCasteCategoryId();
			LOGGER.info("oldCasteId : "+oldCasteId);
			casteId = Long.parseLong(fieldValues.get("casteCategoryId")[0]);
			LOGGER.info("newCasteId : "+casteId);
			if(oldCasteId!=0 && casteId!=0 && oldCasteId!=casteId) {
				CasteCategory oldCaste=CasteCategoryLocalServiceUtil.getCasteCategory(oldCasteId);
				CasteCategory newCaste=CasteCategoryLocalServiceUtil.getCasteCategory(casteId);
				attributes.add("castCategory");
				oldValues.add(oldCaste.getName());
				newValues.add(newCaste.getName());

			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		LOGGER.info("attributes.size()......"+attributes.size());
		if(attributes.isEmpty()) {
			return true;
		}
		String[] arrAttributes=new String[attributes.size()];
		String[] arrOldValues=new String[attributes.size()];
		String[] arrNewValues=new String[attributes.size()];
		
		try {
			for(int i=0;i<attributes.size();i++) {
				arrAttributes[i]=attributes.get(i);
				arrOldValues[i]=oldValues.get(i);
				arrNewValues[i]=newValues.get(i);
			}
			
			LOGGER.info("Before......PISUserUtil.updateIDAMUser");
			PISUserUtil.updateIDAMUser(employee.getLoginId(), arrAttributes, arrOldValues, arrNewValues);
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}
	
	public int getPeopleCountByAppellationId(long appellationId) {
		try {
			return peoplePersistence.countByAppellationId(appellationId);
		}catch(Exception e) {}
		return 0;
	}
	
	public int getPeopleCountByBloodGroupId(long bloodGroupId) {
		try {
			return peoplePersistence.countByBloodGroupId(bloodGroupId);
		}catch(Exception e) {}
		return 0;
	}
	
	public int getPeopleCountByCasteCategoryId(long casteCategoryId) {
		try {
			return peoplePersistence.countByCasteCategoryId(casteCategoryId);
		}catch(Exception e) {}
		return 0;
	}
	
	public int getPeopleCountByCitizenshipId(long citizenshipId) {
		try {
			return peoplePersistence.countByCitizenshipId(citizenshipId);
		}catch(Exception e) {}
		return 0;
	}
	
	public int getPeopleCountByGenderId(long genderId) {
		try {
			return peoplePersistence.countByGenderId(genderId);
		}catch(Exception e) {}
		return 0;
	}
	
	public int getPeopleCountByMaritalStatusId(long maritalStatusId) {
		try {
			return peoplePersistence.countByMaritalStatusId(maritalStatusId);
		}catch(Exception e) {}
		return 0;
	}
	
	public int getPeopleCountByPhTypeId(long phTypeId) {
		try {
			return peoplePersistence.countByPhTypeId(phTypeId);
		}catch(Exception e) {}
		return 0;
	}
	
	public int getPeopleCountByReligionId(long religionId) {
		try {
			return peoplePersistence.countByReligionId(religionId);
		}catch(Exception e) {}
		return 0;
	}
	public List<People> getPeoplesByJoiningProcessId(long joiningProcessId){
		return peoplePersistence.findByJoiningProcessId(joiningProcessId);
	}
}