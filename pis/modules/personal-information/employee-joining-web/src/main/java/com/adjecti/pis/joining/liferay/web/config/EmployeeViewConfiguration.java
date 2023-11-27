package com.adjecti.pis.joining.liferay.web.config;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.adjecti.pis.joining.liferay.web.config.EmployeeViewConfiguration")
public interface EmployeeViewConfiguration {

	@Meta.AD(required = false,deflt = "newJoining")
	public String employeePortletView(); 
	
}