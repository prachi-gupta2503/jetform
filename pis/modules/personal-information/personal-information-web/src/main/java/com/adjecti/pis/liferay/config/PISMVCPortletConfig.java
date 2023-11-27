package com.adjecti.pis.liferay.config;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.adjecti.pis.liferay.web.config.PISPortletViewConfig")
public interface PISMVCPortletConfig {
	public static final String PORTLET_VIEW="portletView";
	
	public static final String MENU="Menu";
	public static final String EMPLOYEE_LIST="Employees List";
	public static final String PROFILE_VIEW="Profile View";
	public static final String PROFILE_CHANGE_REQUEST="Profile Change Request ";
	public static final String DSC_VIEW="Dsc View";
	
	
	@Meta.AD(required = false,deflt = MENU)
	public String portletView(); 
	
}