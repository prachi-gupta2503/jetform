package com.adjecti.noting.web.portlet;

public class NotingDTO {

	long notingId;
	String title;
	String viewUrl;
	public long getNotingId() {
		return notingId;
	}
	public void setNotingId(long notingId) {
		this.notingId = notingId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getViewUrl() {
		return viewUrl;
	}
	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}
	
}
