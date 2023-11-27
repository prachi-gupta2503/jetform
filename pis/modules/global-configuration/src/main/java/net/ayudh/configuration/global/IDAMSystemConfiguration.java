package net.ayudh.configuration.global;

import org.osgi.service.component.annotations.Component;

import net.ayudh.configuration.global.api.IDAM;

@Component(configurationPid="net.ayudh.configuration.global.api.GlobalConfiguration")
public class IDAMSystemConfiguration implements IDAM{

	@Override
	public boolean createEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createAppUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createIDAMUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String defaultUserLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userServiceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

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
