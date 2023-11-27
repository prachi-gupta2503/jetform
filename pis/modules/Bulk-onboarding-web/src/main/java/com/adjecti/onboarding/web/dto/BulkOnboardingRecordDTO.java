package com.adjecti.onboarding.web.dto;

import java.util.Date;

public class BulkOnboardingRecordDTO {

	private long userId;
	private long onboardingId;
	private long fileEntryId;
	private long unitId;
	private String fileName;
	private String remarks;
	private String tittle;
	private long totalRecords;
	private String userName;
	private Date createDate;
	private long totalApprovedRecords;
	private long totalDeletedRecords;
	private long totalRejectedRecords;
	private long totalPendingRecords;
	private long totalDraftRecords;


	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public long getTotalRejectedRecords() {
		return totalRejectedRecords;
	}

	public void setTotalRejectedRecords(long totalRejectedRecords) {
		this.totalRejectedRecords = totalRejectedRecords;
	}

	public long getTotalPendingRecords() {
		return totalPendingRecords;
	}

	public void setTotalPendingRecords(long totalPendingRecords) {
		this.totalPendingRecords = totalPendingRecords;
	}

	public long getTotalDraftRecords() {
		return totalDraftRecords;
	}

	public void setTotalDraftRecords(long totalDraftRecords) {
		this.totalDraftRecords = totalDraftRecords;
	}

	public long getOnboardingId() {
		return onboardingId;
	}

	public void setOnboardingId(long onboardingId) {
		this.onboardingId = onboardingId;
	}

	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
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

	public long getTotalApprovedRecords() {
		return totalApprovedRecords;
	}

	public void setTotalApprovedRecords(long totalApprovedRecords) {
		this.totalApprovedRecords = totalApprovedRecords;
	}

	public long getTotalDeletedRecords() {
		return totalDeletedRecords;
	}

	public void setTotalDeletedRecords(long totalDeletedRecords) {
		this.totalDeletedRecords = totalDeletedRecords;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

	

}
