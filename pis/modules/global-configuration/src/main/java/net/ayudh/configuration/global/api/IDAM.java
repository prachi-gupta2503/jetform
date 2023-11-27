package net.ayudh.configuration.global.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;


@ExtendedObjectClassDefinition(category="Comnet", scope= ExtendedObjectClassDefinition.Scope.SYSTEM)

@Meta.OCD(id = "net.ayudh.configuration.global.api.IDAM")
public interface IDAM {
	
	@Meta.AD(deflt = "", name = "Create Employee", required = false)
    public boolean createEmployee();

	
	@Meta.AD(deflt = "", name = "Create App User", required = false)
    public boolean createAppUser();
	
	
	@Meta.AD(deflt = "", name = "Create IDAM User", required = false)
    public boolean createIDAMUser();
	
	
	@Meta.AD(deflt = "", name = "Default User Location", required = false)
    public String defaultUserLocation();
	
	@Meta.AD(deflt = "", name = "User Service Url", required = false)
    public String userServiceUrl();
	
	@Meta.AD(deflt = "", name = "serverURL", required = false)
    public String serverURL();
	
	@Meta.AD(deflt = "", name = "idam.user.api.endpoint", required = false)
    public String endpoint();

}
