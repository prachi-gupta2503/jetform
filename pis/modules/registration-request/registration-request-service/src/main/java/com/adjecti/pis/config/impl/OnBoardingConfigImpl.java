package com.adjecti.pis.config.impl;

import com.adjecti.pis.configuration.OnBoardingConfig;
import com.adjecti.pis.configuration.OnBoardingConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
		configurationPid = "com.adjecti.pis.configuration.OnBoardingConfiguration")		
public class OnBoardingConfigImpl implements OnBoardingConfig  {

	private volatile OnBoardingConfiguration _onBoardingConfiguration;
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties)
	{
		_onBoardingConfiguration = ConfigurableUtil.createConfigurable(OnBoardingConfiguration.class, properties);		
	}
		
	@Override
	public boolean createEmployee() {
		return _onBoardingConfiguration.createEmployee();
	}

	@Override
	public boolean createAppUser() {
		return _onBoardingConfiguration.createAppUser();
	}

	@Override
	public boolean createIdamUser() {
		return _onBoardingConfiguration.createIdamUser();
	}

	@Override
	public String getPassword() {
		return _onBoardingConfiguration.defaultPassword();
	}

	@Override
	public String getGroup() {
		return _onBoardingConfiguration.defaultGroup();
	}

	@Override
	public String getOrganization() {
		return _onBoardingConfiguration.defaultOrganization();
	}

	@Override
	public String getEmployeeRole() {
		return _onBoardingConfiguration.defaultEmployeeRole();
	}

	@Override
	public String getUserRole() {
		return _onBoardingConfiguration.defaultUserRole();
	}

	@Override
	public String getUserGroup() {
		return _onBoardingConfiguration.defaultUserGroup();
	}

	@Override
	public String getIdamUserLocation() {
		return _onBoardingConfiguration.defaultIdamUserLocation();
	}
	@Override
	public String getIdamUserServiceURL() {
		return _onBoardingConfiguration.idamUserServiceURL();
	}
	
	@Override
	public long getMailQuata() {
		return _onBoardingConfiguration.defaultMailQuota();
	}
	
}
