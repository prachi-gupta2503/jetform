package com.adjecti.pis.liferay.web.model;

public class PostListViewModel {
	private long sNo;
	private String designation;
	private String post;
	private String trade;
	private String fromDate;
	private String toDate;
	private String active;
	public long getsNo() {
		return sNo;
	}
	public void setsNo(long sNo) {
		this.sNo = sNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
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
