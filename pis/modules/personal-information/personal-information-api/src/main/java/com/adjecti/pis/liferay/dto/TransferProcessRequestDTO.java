package com.adjecti.pis.liferay.dto;

import java.util.Date;

public class TransferProcessRequestDTO {

	private long transferProcessRequestId;
	private long groupId;
	private long companyId;
	private long userId;
	private String userName;
	private Date createDate;
	private Date modifiedDate;
	private long transerProcessId;
	private long employeeId;
	private Long organizationId;
	private String organizationName;
	private Date transferDate;
	private Date startDateInNewUnit;
	private Date lastDateInCurrentUnit;
	private String officeOrderNo;
	private long processFileId;
	private String processFileNo;
	private String doPart1Content;
	private long doPart1FileId;
	private String doPart2Content;
	private long doPart2FileId;

	public long getTransferProcessRequestId() {
		return transferProcessRequestId;
	}

	public void setTransferProcessRequestId(long transferProcessRequestId) {
		this.transferProcessRequestId = transferProcessRequestId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getTranserProcessId() {
		return transerProcessId;
	}

	public void setTranserProcessId(long transerProcessId) {
		this.transerProcessId = transerProcessId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getStartDateInNewUnit() {
		return startDateInNewUnit;
	}

	public void setStartDateInNewUnit(Date startDateInNewUnit) {
		this.startDateInNewUnit = startDateInNewUnit;
	}

	public Date getLastDateInCurrentUnit() {
		return lastDateInCurrentUnit;
	}

	public void setLastDateInCurrentUnit(Date lastDateInCurrentUnit) {
		this.lastDateInCurrentUnit = lastDateInCurrentUnit;
	}

	public String getOfficeOrderNo() {
		return officeOrderNo;
	}

	public void setOfficeOrderNo(String officeOrderNo) {
		this.officeOrderNo = officeOrderNo;
	}

	public long getProcessFileId() {
		return processFileId;
	}

	public void setProcessFileId(long processFileId) {
		this.processFileId = processFileId;
	}

	public String getProcessFileNo() {
		return processFileNo;
	}

	public void setProcessFileNo(String processFileNo) {
		this.processFileNo = processFileNo;
	}

	public String getDoPart1Content() {
		return doPart1Content;
	}

	public void setDoPart1Content(String doPart1Content) {
		this.doPart1Content = doPart1Content;
	}

	public long getDoPart1FileId() {
		return doPart1FileId;
	}

	public void setDoPart1FileId(long doPart1FileId) {
		this.doPart1FileId = doPart1FileId;
	}

	public String getDoPart2Content() {
		return doPart2Content;
	}

	public void setDoPart2Content(String doPart2Content) {
		this.doPart2Content = doPart2Content;
	}

	public long getDoPart2FileId() {
		return doPart2FileId;
	}

	public void setDoPart2FileId(long doPart2FileId) {
		this.doPart2FileId = doPart2FileId;
	}

}
