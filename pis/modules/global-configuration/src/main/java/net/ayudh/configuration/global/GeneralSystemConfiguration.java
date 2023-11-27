package net.ayudh.configuration.global;

import org.osgi.service.component.annotations.Component;

import net.ayudh.configuration.global.api.General;

@Component(configurationPid="net.ayudh.configuration.global.api.GlobalConfiguration")
public class GeneralSystemConfiguration implements General{

	@Override
	public String defaultUserPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String defaultGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String defaultOrganization() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String defaultEmployeeRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String defaultUserRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String defaultUserGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unitEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
