package net.ofb.dashboard.egov.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "EGovServiceConfiguration", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)

@Meta.OCD(id = "com.adjecti.dashboard.egov.configuration.EGovServiceConfiguration")
public interface EGovServiceConfiguration {

    @Meta.AD(required = false, name = "EGovURL")
    public String getURL();

}