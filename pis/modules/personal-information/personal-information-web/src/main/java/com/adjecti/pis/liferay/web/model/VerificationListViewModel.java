package com.adjecti.pis.liferay.web.model;

public class VerificationListViewModel {
	private long sNo;
	private String unit;
	private String workArea;
	private String fromDate;
	private String toDate;
	private String active;
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
	public String getWorkArea() {
		return workArea;
	}
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
}
