package net.ofb.comnet2.dashboard.calendar.model;

import java.util.ArrayList;

public class Event {

	public String title;
	public String start;
	public String end;
	public String location;
	public String initiatedBy;
	public ArrayList<String> invitees;
	public String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	public ArrayList<String> getInvitees() {
		return invitees;
	}

	public void setInvitees(ArrayList<String> invitees) {
		this.invitees = invitees;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "{ 'title':'" + title + "', 'start':'" + start + "', 'end':'" + end + "', 'location':'" + location
				+ "', 'initiatedBy':'" + initiatedBy + "', 'invitees':'" + invitees + "', 'url':'" + url + "'}";
	}

}
