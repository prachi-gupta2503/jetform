package com.adjecti.pis.liferay.web.model;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.repository.model.FileEntry;

public class UserViewModel {
	
	private FileEntry image;                           
	private String firstName;
	private String middleName;
	private String lastName;
	private Long employeeNo;                               
	private String designation;                             
	private String email;                                      

	
	
	public FileEntry getImage() {
		return image;
	}
	public void setImage(FileEntry image) {
		this.image = image;
	}
	public Long getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	 
	
}
