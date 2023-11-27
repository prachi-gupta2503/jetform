package com.adjecti.pis.liferay.web.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherInfoViewModel {
	
	private List<String> modulelist=new ArrayList<String>(Arrays.asList("Address","Application Access","Benefit Scheme","Confirmation","Deputation","Experience","Joining","Joining Process","Past Experience","Post","Promotion","Qualification","Reporting","Seniority","Training","Transfer","Transfer Process","Verification","Workstation"));

	//private List<String> modulelist=new ArrayList<String>();         //new ArrayList<String>(Arrays.asList("Address","Application Access","Benefit Scheme","Confirmation","Deputation","Experience","Joining","Joining Process","Past Experience","Post","Promotion","Qualification","Reporting","Seniority","Training","Transfer","Transfer Process","Verification","Workstation"));

	public List<String> getModulelist() {
		return modulelist;
	}

//	public void setModulelist(List<String> modulelist) {
//		this.modulelist = modulelist;
//	}

	
}
