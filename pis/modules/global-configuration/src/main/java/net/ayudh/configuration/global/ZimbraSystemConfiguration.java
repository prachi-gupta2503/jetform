package net.ayudh.configuration.global;

import org.osgi.service.component.annotations.Component;

import net.ayudh.configuration.global.api.Zimbra;

@Component(configurationPid="net.ayudh.configuration.global.api.GlobalConfiguration")
public class ZimbraSystemConfiguration implements Zimbra{

	@Override
	public String defaultMailQuata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String serverURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mailEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mailUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
