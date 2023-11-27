package net.ayudh.portal.employee.web.config;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "net.ayudh.portal.employee.web.config.ViewConfiguration")
public interface ViewConfiguration {

	@Meta.AD(required = false,deflt = "view")
	public String portletView(); 
	
	@Meta.AD(required = false)
	public String baseUrl();
	
	@Meta.AD(required = false)
	public String gradeId();
	
	
}