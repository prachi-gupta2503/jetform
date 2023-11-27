package com.adjecti.pis.liferay.web.model;

public class DeputationListViewModel {
	private long sNo;
	private String ministry;
	private String department;
	private String deputationType;
	private String deputedPost;
	private String fromDate;
	private String toDate;
	private String active;
	public long getsNo() {
		return sNo;
	}
	public void setsNo(long sNo) {
		this.sNo = sNo;
	}
	public String getMinistry() {
		return ministry;
	}
	public void setMinistry(String ministry) {
		this.ministry = ministry;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDeputationType() {
		return deputationType;
	}
	public void setDeputationType(String deputationType) {
		this.deputationType = deputationType;
	}
	public String getDeputedPost() {
		return deputedPost;
	}
	public void setDeputedPost(String deputedPost) {
		this.deputedPost = deputedPost;
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
