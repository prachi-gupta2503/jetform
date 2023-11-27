package com.adjecti.pis.liferay.web.model;

import com.liferay.portal.kernel.repository.model.FileEntry;

public class EmployeeViewModel {
	
	FileEntry image;
	String personalNo;
	String name;
	String designation;
	String division;
	String factorySaction;
	String email;
	long employeeId;
	
	

	public FileEntry getImage() {
		return image;
	}
	public void setImage(FileEntry image) {
		this.image = image;
	}
	public String getPersonalNo() {
		return personalNo;
	}
	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getFactorySaction() {
		return factorySaction;
	}
	public void setFactorySaction(String factorySaction) {
		this.factorySaction = factorySaction;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
