package net.ayudh.configuration.global.api;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category="Comnet", scope= ExtendedObjectClassDefinition.Scope.SYSTEM)

@Meta.OCD(id = "net.ayudh.configuration.global.api.Zimbra")
public interface Zimbra {
	@Meta.AD(deflt = "", name = "Default Mail Quata", required = false)
    public String defaultMailQuata();
	
	@Meta.AD(deflt = "", name = "serverURL", required = false)
    public String serverURL();
	
	@Meta.AD(deflt = "", name = "mail.inbox.count.endpoint", required = false)
    public String mailEndpoint();
	
	@Meta.AD(deflt = "", name = "mail.dashboard.calendar.url", required = false)
    public String mailUrl();

}
