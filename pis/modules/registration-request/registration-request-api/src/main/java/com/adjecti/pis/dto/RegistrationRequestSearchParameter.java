package com.adjecti.pis.dto;

public class RegistrationRequestSearchParameter {
	private long[] unitIds;
	private int [] statuses;
	private long [] groupIds;
	private long bulkOnbordingFileId;
	private long designationId;
	private long gradeId;
	private long tradeId;
	private String targetAction;
	private boolean excludeInvalid;
	
	public long[] getUnitIds() {
		return unitIds;
	}
	public void setUnitIds(long[] unitIds) {
		this.unitIds = unitIds;
	}
	public int[] getStatuses() {
		return statuses;
	}
	public void setStatuses(int[] statuses) {
		this.statuses = statuses;
	}
	
	
	public long getBulkOnbordingFileId() {
		return bulkOnbordingFileId;
	}
	public void setBulkOnbordingFileId(long bulkOnbordingFileId) {
		this.bulkOnbordingFileId = bulkOnbordingFileId;
	}
	public long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}
	public long getGradeId() {
		return gradeId;
	}
	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}
	public long getTradeId() {
		return tradeId;
	}
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	public long [] getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(long [] groupIds) {
		this.groupIds = groupIds;
	}
	public String getTargetAction() {
		return targetAction;
	}
	public void setTargetAction(String targetAction) {
		this.targetAction = targetAction;
	}
	public boolean isExcludeInvalid() {
		return excludeInvalid;
	}
	public void setExcludeInvalid(boolean excludeInvalid) {
		this.excludeInvalid = excludeInvalid;
	}
		
}
