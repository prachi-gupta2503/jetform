package com.adjecti.pis.configuration;

public interface OnBoardingConfig {
	
	public boolean createEmployee();

	public boolean createAppUser();
	
	public boolean createIdamUser();
	
	public String getPassword();
	
	public String getGroup();

	public String getOrganization();
	
	public String getEmployeeRole();
	
	public String getUserRole();
	
	public String getUserGroup();
	
	public String getIdamUserLocation();
	
	public String getIdamUserServiceURL();
	
	public long getMailQuata();

}


