package net.ayudh.configuration.global.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category="Comnet", scope= ExtendedObjectClassDefinition.Scope.SYSTEM)

@Meta.OCD(id = "net.ayudh.configuration.global.api.General")
public interface General {
	@Meta.AD(deflt = "", name = "Default User Password", required = false)
    public String defaultUserPassword();
	
	@Meta.AD(deflt = "", name = "Default Group", required = false)
    public String defaultGroup();
	
	@Meta.AD(deflt = "", name = "Default Organization", required = false)
    public String defaultOrganization();
	
	@Meta.AD(deflt = "", name = "Default Employee Role", required = false)
    public String defaultEmployeeRole();
	

	@Meta.AD(deflt = "", name = "Default User Role", required = false)
    public String defaultUserRole();
	

	@Meta.AD(deflt = "", name = "Default User Group", required = false)
    public String defaultUserGroup();

	@Meta.AD(deflt = "", name = "unit.section.list.api.endpoint", required = false)
    public String unitEndpoint();
}
