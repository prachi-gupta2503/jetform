package com.adjecti.pis.dto;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class RegistrationRequestDTO {


	private long registrationRequestId;
	private String status;
	private Date statusDate;
	private long unitId;
	private String unit;
	private long recordNo;
	private long personalNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private long genderId;
	private String genderName;
	private long designationId;
	private String designationName;
	private String designationCode;
	private long tradeId;
	private String trade;
	private String tradeCode;
	private long gradeId;
	private String grade;
	private String gradeCode;
	private String postBox;
	private long rank;
	private Date dateOfBirth;
	private Date dateOfJoiningOrganization;
	private long casteCategoryId;
	private String castCategory;
	private long mobile;
	private String emailAddress;
	private Date dateOfJoiningUnit;
	private String gpfnpsType;
	private long gpfnpsNumber;
	private long sectionId;
	private String sectionCode;
	private String section;
	private String loginId;
	private long fileEntryId;
	private boolean isApprover;
	
    private boolean idamUser ;
    private boolean emailAccess;
    private boolean digitalSigning; 
    private boolean eGovAccess; 
    private boolean pisAccess;
    private long taskId;
    private String errorMessage;
    private boolean editable;
	private boolean assignable;
	private long bulkOnbordingFileId;
	private Date modifiedDate;
  

public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

public boolean isAssignable() {
		return assignable;
	}

	public void setAssignable(boolean assignable) {
		this.assignable = assignable;
	}

    
	
	public long getBulkOnbordingFileId() {
		return bulkOnbordingFileId;
	}

	public void setBulkOnbordingFileId(long bulkOnbordingFileId) {
		this.bulkOnbordingFileId = bulkOnbordingFileId;
	}

	public String getFullName() {
		String fullName = 
			    Stream.of(firstName, middleName, lastName)
			          .filter(s -> s != null && !s.isEmpty())
			          .collect(Collectors.joining(" "));
		
		return fullName;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	private List<String> actions;

	public long getRegistrationRequestId() {
		return registrationRequestId;
	}

	public void setRegistrationRequestId(long registrationRequestId) {
		this.registrationRequestId = registrationRequestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setStatus(int status) {
		String  statusDesc = "";
		if (status == WorkflowConstants.STATUS_DRAFT)
			statusDesc = "DRAFT";
		else if (status == WorkflowConstants.STATUS_APPROVED)
			statusDesc = "APPROVED";
		else if (status == WorkflowConstants.STATUS_DENIED)
			statusDesc = "REJECTED";
		else if (status == WorkflowConstants.STATUS_PENDING)
			statusDesc = "PENDING";
		else if (status == WorkflowConstants.STATUS_SCHEDULED)
			statusDesc = "APPROVAL PENDING";
		
		
		this.status = statusDesc;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getUnit() {
		return unit;
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
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = StringUtils.upperCase(trim(firstName));
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = StringUtils.upperCase(trim(lastName));
	}

	public long getGenderId() {
		return genderId;
	}

	public void setGenderId(long genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public long getTradeId() {
		return tradeId;
	}

	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public long getGradeId() {
		return gradeId;
	}

	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoiningOrganization() {
		return dateOfJoiningOrganization;
	}

	public void setDateOfJoiningOrganization(Date dateOfJoiningOrganization) {
		this.dateOfJoiningOrganization = dateOfJoiningOrganization;
	}

	public long getCasteCategoryId() {
		return casteCategoryId;
	}

	public void setCasteCategoryId(long casteCategoryId) {
		this.casteCategoryId = casteCategoryId;
	}

	public String getCastCategory() {
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = StringUtils.lowerCase(emailAddress);
	}

	public Date getDateOfJoiningUnit() {
		return dateOfJoiningUnit;
	}

	public void setDateOfJoiningUnit(Date dateOfJoiningUnit) {
		this.dateOfJoiningUnit = dateOfJoiningUnit;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public boolean isApprover() {
		return isApprover;
	}

	public void setApprover(boolean isApprover) {
		this.isApprover = isApprover;
	}

	public List<String> getActions() {
		return actions;
	}
	
	public void setActions(List<String> actions) {
		this.actions = actions;
	}
	
	public boolean hasAction(String action){
		if(actions == null) {
			return false;
		}
		
		return actions.contains(action) ;
	}

	public long getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(long recordNo) {
		this.recordNo = recordNo;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = StringUtils.upperCase(trim(middleName));
	}

	public String getGpfnpsType() {
		return gpfnpsType;
	}

	public void setGpfnpsType(String gpfnpsType) {
		if(gpfnpsType !=null)
		{
			gpfnpsType.toUpperCase();
		}
		this.gpfnpsType = gpfnpsType;
	}

	public long getGpfnpsNumber() {
		return gpfnpsNumber;
	}
	
	public String getGpfnpsNumberView() {
		return gpfnpsNumber!=0?String.valueOf(gpfnpsNumber):"";
	}

	public void setGpfnpsNumber(long gpfnpsNumber) {
		this.gpfnpsNumber = gpfnpsNumber;
	}

	public boolean isIdamUser() {
		return idamUser;
	}

	public void setIdamUser(boolean idamUser) {
		this.idamUser = idamUser;
	}

	public boolean isEmailAccess() {
		return emailAccess;
	}

	public void setEmailAccess(boolean emailAccess) {
		this.emailAccess = emailAccess;
	}

	public boolean isDigitalSigning() {
		return digitalSigning;
	}

	public void setDigitalSigning(boolean digitalSigning) {
		this.digitalSigning = digitalSigning;
	}

	public boolean iseGovAccess() {
		return eGovAccess;
	}

	public void seteGovAccess(boolean eGovAccess) {
		this.eGovAccess = eGovAccess;
	}

	public boolean isPisAccess() {
		return pisAccess;
	}

	public void setPisAccess(boolean pisAccess) {
		this.pisAccess = pisAccess;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public String getAllowedActions() {
		if(StringUtils.isBlank(errorMessage) || CollectionUtils.isEmpty(actions) || !assignable){
			return "";
		}
		
		return String. join("#", actions);
	}

	public String getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getPostBox() {
		return postBox;
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
