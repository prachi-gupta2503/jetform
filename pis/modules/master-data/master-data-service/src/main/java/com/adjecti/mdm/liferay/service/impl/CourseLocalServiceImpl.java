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

import com.adjecti.mdm.liferay.model.Course;
import com.adjecti.mdm.liferay.service.base.CourseLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.mdm.liferay.service.CourseLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.mdm.liferay.model.Course",
	service = AopService.class
)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.mdm.liferay.service.CourseLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.mdm.liferay.service.CourseLocalServiceUtil</code>.
	 */
	
	public boolean dataIsAvailbleOrNot(String fieldName,String fieldValue) {
		boolean isDataAvailabe=false;
		switch (fieldName) {
		       case "a3":
		    	   Country fetchCountryByA3 = CountryServiceUtil.fetchCountryByA3(fieldValue);
			          if(Validator.isNotNull(fetchCountryByA3)) {
			        	  isDataAvailabe=true;
			          }
			
			    break;
			   case "a2":
				   Country fetchCountryByA2 = CountryServiceUtil.fetchCountryByA2(fieldValue);
				   if(Validator.isNotNull(fetchCountryByA2)) {
						isDataAvailabe=true;
					}
			    break;
			   case "name":
			try {
				Country countryByName = CountryServiceUtil.getCountryByName(fieldValue);
				if(Validator.isNotNull(countryByName)) {
					isDataAvailabe=true;
				}
			} catch (PortalException e) {
				
				//e.printStackTrace();
			}
			    break;
			   case "number":
				   
				   System.out.println("fetchCountry.getNumber() "+Long.parseLong(fieldValue));
				   long id=Long.parseLong(fieldValue);
				   List<Country> countries = CountryServiceUtil.getCountries();
				   List<Country> collect = countries.stream().filter(x -> x.getNumber().equals(fieldValue)).collect(Collectors.toList());
				   System.out.println("fetchCountry.getNumber() collect "+collect+"  Validator.isNotNull(collect) "+Validator.isNotNull(collect));

				  //System.out.println("fetchCountry.getNumber() equal  "+fetchCountry.getNumber().equalsIgnoreCase(fieldValue));
				   if(!collect.isEmpty()) {
					   System.out.println("fetchCountry.getNumber() inside if "+collect.isEmpty());
						isDataAvailabe=true;
					}
			    break;
			  
		}
		 
		
		 
		 
		
		
		return isDataAvailabe;
		
	}
	
	
	
	public List<Course> getBySubjectOfTrainingIdAndStatus(long subjectOfTrainingId,int status){
		return	coursePersistence.findBySubjectOfTrainingIdAndStatus(subjectOfTrainingId, status); 
	}
	
}