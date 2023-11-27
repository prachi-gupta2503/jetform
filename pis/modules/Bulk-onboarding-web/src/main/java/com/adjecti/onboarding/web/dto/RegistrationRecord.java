package com.adjecti.onboarding.web.dto;

import com.adj.xls.annotation.ExcelCell;
import com.adj.xls.annotation.ExcelRow;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class RegistrationRecord {

	@ExcelRow
    private int rowIndex;
    @ExcelCell(0)
	private long employeeNumber; //Sl No
    @ExcelCell(1)
    private String unit; //Unit
    @ExcelCell(2)
    private String section; //Section
    @ExcelCell(3)
    private long personalNo; //Personal No
    @ExcelCell(4)
    private String postBox;
    @ExcelCell(5)
    private long rank;
    @ExcelCell(6)
    private String trade; //Trade
    @ExcelCell(7)
    private String grade; //Grade
    @ExcelCell(8)
    private String designation ; //Designation
    @ExcelCell(9)
    private Date dateOfJoiningUnit; //Date Of Joining Unit
    @ExcelCell(10)
    private String firstName; //First Name
    @ExcelCell(11)
    private String middleName;	//Middle Name	
    @ExcelCell(12)
    private String lastName;    //last Name
    @ExcelCell(13)
    private String gender; //Male, Female, Transgender
    @ExcelCell(14)
    private Date dateOfBirth; //Date Of Birth
    @ExcelCell(15)
    private String castCategory;// Caste Category (ST, SC, OBC, General)
    @ExcelCell(16)
	private long mobile; //Mobile No
    @ExcelCell(17)
    private String emailId; //Email Id
    @ExcelCell(18)
    private String gpfNpsType; // "GPF" or "NPS" 
    @ExcelCell(19)
    private long gpfNpsNumber; //GPF/NPS No
    @ExcelCell(20)
    private String idamUser ;//IDAM User  - (Yes/No
    @ExcelCell(21)
    private String emailAccess; //email Access - yes/no
    @ExcelCell(22)
    private String digitalSigning; //digital Signing
    @ExcelCell(23)
    private String eGovAccess; // eGov Access
    @ExcelCell(24)
    private String pisAccess; // pis Access
	    
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getUnit() {
		return trim(unit);
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public long getPersonalNo() {
		return personalNo;
	}
	public void setPersonalNo(long personalNo) {
		this.personalNo = personalNo;
	}
	public String getFirstName() {
		return StringUtils.upperCase(trim(firstName));
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return StringUtils.upperCase((trim(middleName)));
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return StringUtils.upperCase(trim(lastName));
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		if(StringUtils.isBlank(gender))
			return trim(gender);
		
		if("M".equalsIgnoreCase(gender))
			return "Male";
		if("F".equalsIgnoreCase(gender))
			return "Female";
		if("T".equalsIgnoreCase(gender))
			return "Transgende";
		if("O".equalsIgnoreCase(gender))
			return "gender";
		
		return trim(gender);
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return trim(designation);
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getTrade() {
		return trim(trade);
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getGrade() {
		return trim(grade);
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCastCategory() {
		castCategory = trim(castCategory);
		if(StringUtils.isBlank(castCategory)) {
			return castCategory;
		}
		if("G".equalsIgnoreCase(castCategory) || "GC".equalsIgnoreCase(castCategory) || "GEN".equalsIgnoreCase(castCategory) || "GN".equalsIgnoreCase(castCategory)) {
			return "General";
		}
		return castCategory;
	}
	public void setCastCategory(String castCategory) {
		this.castCategory = castCategory;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmailId() {
		return StringUtils.lowerCase(trim(emailId));
	}
	public void setEmailId(String emailId) {
		this.emailId = StringUtils.lowerCase(trim(emailId));
	}
	public Date getDateOfJoiningUnit() {
		return dateOfJoiningUnit;
	}
	public void setDateOfJoiningUnit(Date dateOfJoiningUnit) {
		this.dateOfJoiningUnit = dateOfJoiningUnit;
	}
	
	public String getGpfNpsType() {
		return trim(gpfNpsType);
	}
	public void setGpfNpsType(String gpfNpsType) {
		this.gpfNpsType = gpfNpsType;
	}
	public long getGpfNpsNumber() {
		return gpfNpsNumber;
	}
	public void setGpfNpsNumber(long gpfNpsNumber) {
		this.gpfNpsNumber = gpfNpsNumber;
	}
	public String getSection() {
		return trim(section);
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getIdamUser() {
		return trim(idamUser);
	}
	public void setIdamUser(String idamUser) {
		this.idamUser = idamUser;
	}
	public String getEmailAccess() {
		return StringUtils.lowerCase(trim(emailAccess));
	}
	public void setEmailAccess(String emailAccess) {
		this.emailAccess = StringUtils.lowerCase(emailAccess);
	}
	public String getDigitalSigning() {
		return trim(digitalSigning);
	}
	public void setDigitalSigning(String digitalSigning) {
		this.digitalSigning = digitalSigning;
	}
	public String geteGovAccess() {
		return trim(eGovAccess);
	}
	public void seteGovAccess(String eGovAccess) {
		this.eGovAccess = eGovAccess;
	}
	public String getPisAccess() {
		return trim(pisAccess);
	}
	public void setPisAccess(String pisAccess) {
		this.pisAccess = pisAccess;
	}
	public String getPostBox() {
		return trim(postBox);
	}
	public void setPostBox(String postBox) {
		this.postBox = postBox;
	}
	public long getRank() {
		return rank;
	}
	public void setRank(long rank) {
		this.rank = rank;
	}
	
	private String trim(String str) {
		String trimStr= StringUtil.trim(str);
		return StringUtils.isNotBlank(trimStr)? trimStr : str;
	}
}
