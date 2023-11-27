package com.adjecti.pis.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "OnBoardingConfiguration",scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
	
@Meta.OCD(id = "com.adjecti.pis.configuration.OnBoardingConfiguration")
public interface OnBoardingConfiguration {
		
	@Meta.AD(required = false, deflt = "true",name = "Create Employee")
	public boolean createEmployee();
	
	@Meta.AD(required = false, deflt = "true",name = "Create App User")
	public boolean createAppUser();
	
	@Meta.AD(required = false, deflt = "true",name = "Create Idam User")
	public boolean createIdamUser();

	@Meta.AD(required = false, deflt = "oFb@700001",name = "Default User Password")
	public String defaultPassword();
	
	@Meta.AD(required = false, deflt = "Comnet 2.0",name = "Default Group")
	public String defaultGroup();
		
	@Meta.AD(required = false, deflt = "Ordnance Factory Board",name = "Default Organization")
	public String defaultOrganization();
	
	@Meta.AD(required = false, deflt = "Employee",name = "Default Employee Role")
	public String defaultEmployeeRole();
	
	@Meta.AD(required = false, deflt = "User",name = "Default User Role")
	public String defaultUserRole();
	
	@Meta.AD(required = false, deflt = "Employee",name = "Default User Group")
	public String defaultUserGroup();
	
	@Meta.AD(required = false, deflt = "Kolkata",name = "Default Idam User Location")
	public String defaultIdamUserLocation();
	
	@Meta.AD(required = false,deflt = "http://172.20.115.26:8095/user",name = "Idam User Service URL")
	public String idamUserServiceURL();
	
	@Meta.AD(required = false, deflt = "1024", name = "Default Mail Quata")
	public long defaultMailQuota();


}

    

