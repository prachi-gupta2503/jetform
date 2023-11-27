package com.adjecti.jetform.list.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FieldDef implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String data;
	private String dataType;
	private String dataFormat;
	private String dataStyle;
	private String label;
	private String labelStyle;
	private String sort;
	private String cssStyle;
	private String cssClass;
	private String width;
	private boolean hidden;
	
	List<ActionControl> controls = new ArrayList<ActionControl>();

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public String getDataStyle() {
		return dataStyle;
	}

	public void setDataStyle(String dataStyle) {
		this.dataStyle = dataStyle;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(String labelStyle) {
		this.labelStyle = labelStyle;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public boolean isHidden() {

		return hidden;
	}

	public void setHidden(boolean hidden) {

		this.hidden = hidden;
	}

	public List<ActionControl> getControls() {
		return controls;
	}

	public void setControls(List<ActionControl> controls) {
		this.controls = controls;
	}

	public int controlsSize() {
		return controls.size();
	}

	public boolean isControlsEmpty() {
		return controls.isEmpty();
	}

	public boolean containsControl(Object o) {
		return controls.contains(o);
	}

	public Iterator<ActionControl> controlsIterator() {
		return controls.iterator();
	}

	public boolean addControl(ActionControl e) {
		return controls.add(e);
	}

	public boolean removeControl(Object o) {
		return controls.remove(o);
	}

	public boolean addAllControls(Collection<? extends ActionControl> c) {
		return controls.addAll(c);
	}

	public void clearControls() {
		controls.clear();
	}

	public ActionControl getControl(int index) {
		return controls.get(index);
	}

	public ActionControl setControl(int index, ActionControl element) {
		return controls.set(index, element);
	}

	public void addControl(int index, ActionControl element) {
		controls.add(index, element);
	}

	public ActionControl removeControl(int index) {
		return controls.remove(index);
	}

	public int indexOfControl(Object o) {
		return controls.indexOf(o);
	}
}
