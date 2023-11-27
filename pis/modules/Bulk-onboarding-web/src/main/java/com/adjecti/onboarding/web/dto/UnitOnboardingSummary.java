package com.adjecti.onboarding.web.dto;

public class UnitOnboardingSummary {
	private long unitId;
	private String unitName;
	private long totalUploads;
	private long totalRecords;
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
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
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
	public long getTotalUploads() {
		return totalUploads;
	}
	public void setTotalUploads(long totalUploads) {
		this.totalUploads = totalUploads;
	}
	
	
	
	
}
