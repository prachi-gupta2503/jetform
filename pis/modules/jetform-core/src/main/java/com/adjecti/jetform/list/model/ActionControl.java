package com.adjecti.jetform.list.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActionControl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String elementId;
	private String type;
	private String caption;
	private String event;
	private String eventAction;
	private String css;
	private String enable;
	private String visible;
	private List<String> params = new ArrayList<String>();
	private String key;
	private String icon;


	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	
	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getCaption() {

		return caption;
	}

	public void setCaption(String caption) {

		this.caption = caption;
	}

	public String getEvent() {

		return event;
	}

	public void setEvent(String event) {

		this.event = event;
	}

	public String getEventAction() {

		return eventAction;
	}

	public void setEventAction(String eventAction) {

		this.eventAction = eventAction;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getKey() {

		return key;
	}

	public void setKey(String key) {

		this.key = key;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public int paramsSize() {
		return params.size();
	}

	public boolean isParamsEmpty() {
		return params.isEmpty();
	}

	public boolean containsParam(Object o) {
		return params.contains(o);
	}

	public Iterator<String> paramsIterator() {
		return params.iterator();
	}

	public boolean addParam(String e) {
		return params.add(e);
	}

	public boolean removeParam(Object o) {
		return params.remove(o);
	}

	public boolean addAllParams(Collection<? extends String> c) {
		return params.addAll(c);
	}

	public void clearParams() {
		params.clear();
	}

	public String getParam(int index) {
		return params.get(index);
	}

	public String setParam(int index, String element) {
		return params.set(index, element);
	}

	public void addParam(int index, String element) {
		params.add(index, element);
	}

	public String removeParam(int index) {
		return params.remove(index);
	}

	public int indexOfParam(Object o) {
		return params.indexOf(o);
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
