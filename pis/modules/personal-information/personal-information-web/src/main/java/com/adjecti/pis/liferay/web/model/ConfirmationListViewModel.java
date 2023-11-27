package com.adjecti.pis.liferay.web.model;

public class ConfirmationListViewModel {
	private long sNo;
	private String unit;
	private String designation;
	private String grade;
	private String trade;
	private String gradeMode;
	private String confirmationDate;
	public long getsNo() {
		return sNo;
	}
	public void setsNo(long sNo) {
		this.sNo = sNo;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getGradeMode() {
		return gradeMode;
	}
	public void setGradeMode(String gradeMode) {
		this.gradeMode = gradeMode;
	}
	public String getConfirmationDate() {
		return confirmationDate;
	}
	public void setConfirmationDate(String confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

}
