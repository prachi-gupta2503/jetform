package net.ayudh.comnet.admin.dto;

import com.adjecti.pis.liferay.model.Employee;

import net.ayudh.comnet.admin.model.ApplicationUser;

public class ApplicationUserDto {
	private long applicationUserId;
	private String personalNo;
	private String fullName;
	private String email;
	private String loginId;
	private int status;
	private boolean idamUser;
	private boolean idamServiceStatus;
	private String idamServiceMessage;
	private boolean emailAccess;
	private boolean digitalSigning;
	private boolean eGovAccess;
	private boolean pisAccess;
//	private boolean lastIdamUser;
//	private boolean lastEmailAccess;
//	private boolean lastDigitalSigning;
//	private boolean lastEGovAccess;
//	private boolean lastPisAccess;
	
	public ApplicationUserDto() {
		
	}
	public ApplicationUserDto(ApplicationUser entity) {
		this.setApplicationUserId(entity.getApplicationUserId());
		this.setStatus(entity.getStatus());
		this.setIdamUser(entity.getIdamUser());
		this.setIdamServiceStatus(entity.getIdamServiceStatus());
		this.setIdamServiceMessage(entity.getIdamServiceMessage());
		this.setEmailAccess(entity.getEmailAccess());
		this.setDigitalSigning(entity.getDigitalSigning());
		this.seteGovAccess(entity.getEGovAccess());
		this.setPisAccess(entity.getPisAccess());
	}
	public ApplicationUserDto(ApplicationUser entity,Employee employee) {
		this.setApplicationUserId(entity.getApplicationUserId());
		this.setStatus(entity.getStatus());
		this.setIdamUser(entity.getIdamUser());
		this.setIdamServiceStatus(entity.getIdamServiceStatus());
		this.setIdamServiceMessage(entity.getIdamServiceMessage());
		this.setEmailAccess(entity.getEmailAccess());
		this.setDigitalSigning(entity.getDigitalSigning());
		this.seteGovAccess(entity.getEGovAccess());
		this.setPisAccess(entity.getPisAccess());
		this.setApplicationUserId(entity.getApplicationUserId());
		this.setPersonalNo(employee.getPersonalNo());
		this.setFullName(employee.getFullName_En());
		this.setEmail(employee.getEmailId());
		this.setLoginId(employee.getLoginId());
		
	}
	public long getApplicationUserId() {
		return applicationUserId;
	}
	public void setApplicationUserId(long applicationUserId) {
		this.applicationUserId = applicationUserId;
	}
	public String getPersonalNo() {
		return personalNo;
	}
	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isIdamUser() {
		return idamUser;
	}
	public void setIdamUser(boolean idamUser) {
		this.idamUser = idamUser;
	}
	public boolean isIdamServiceStatus() {
		return idamServiceStatus;
	}
	public void setIdamServiceStatus(boolean idamServiceStatus) {
		this.idamServiceStatus = idamServiceStatus;
	}
	public String getIdamServiceMessage() {
		return idamServiceMessage;
	}
	public void setIdamServiceMessage(String idamServiceMessage) {
		this.idamServiceMessage = idamServiceMessage;
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
//	public boolean isLastIdamUser() {
//		return lastIdamUser;
//	}
//	public void setLastIdamUser(boolean lastIdamUser) {
//		this.lastIdamUser = lastIdamUser;
//	}
//	public boolean isLastEmailAccess() {
//		return lastEmailAccess;
//	}
//	public void setLastEmailAccess(boolean lastEmailAccess) {
//		this.lastEmailAccess = lastEmailAccess;
//	}
//	public boolean isLastDigitalSigning() {
//		return lastDigitalSigning;
//	}
//	public void setLastDigitalSigning(boolean lastDigitalSigning) {
//		this.lastDigitalSigning = lastDigitalSigning;
//	}
//	public boolean isLastEGovAccess() {
//		return lastEGovAccess;
//	}
//	public void setLastEGovAccess(boolean lastEGovAccess) {
//		this.lastEGovAccess = lastEGovAccess;
//	}
//	public boolean isLastPisAccess() {
//		return lastPisAccess;
//	}
//	public void setLastPisAccess(boolean lastPisAccess) {
//		this.lastPisAccess = lastPisAccess;
//	}

}
