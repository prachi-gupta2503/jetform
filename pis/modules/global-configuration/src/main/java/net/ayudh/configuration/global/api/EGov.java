package net.ayudh.configuration.global.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category="Comnet", scope= ExtendedObjectClassDefinition.Scope.SYSTEM)

@Meta.OCD(id = "net.ayudh.configuration.global.api.EGov")
public interface EGov {

	@Meta.AD(deflt = "", name = "serverURL", required = false)
    public String serverURL();
	
	@Meta.AD(deflt = "", name = "egov.inbox.count.endpoint", required = false)
    public String endpoint();
	
}
