package net.ayudh.configuration.global;

import org.osgi.service.component.annotations.Component;

import net.ayudh.configuration.global.api.EGov;

@Component(configurationPid="net.ayudh.configuration.global.api.GlobalConfiguration")
public class EGovSystemConfiguration implements EGov{

	@Override
	public String serverURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String endpoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
