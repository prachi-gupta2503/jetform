package net.ofb.dashboard.egov.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(configurationPid = "com.adjecti.dashboard.egov.configuration.EGovCountConfiguration")
public class EGovCountConfigImpl implements EGovServiceConfig {

    private volatile EGovServiceConfiguration eGovServiceConfiguration;

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	eGovServiceConfiguration = ConfigurableUtil.createConfigurable(EGovServiceConfiguration.class, properties);
    }

    @Override	
    public String getURL() {
        return eGovServiceConfiguration.getURL();
    }

}