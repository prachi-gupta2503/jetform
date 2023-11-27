package com.adjecti.jetform.annotation;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HtmlElementGroupWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String id;
	String name;
	int widthPercentage;
	int elementsPerRow;
	int align;
	boolean newRow=true;
	List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
	List<String> rules=new ArrayList<String>();
	
	public HtmlElementGroupWrapper() {
		super();
	}

	public HtmlElementGroupWrapper(String id, String name, int widthPercentage, int align, int elementsPerRow, boolean newRow) {
		super();
		this.id = id;
		this.name = name;
		this.widthPercentage=widthPercentage;
		this.align=align;
		this.elementsPerRow=elementsPerRow;
		this.newRow=newRow;
	}

	public HtmlElementGroupWrapper(HtmlElementGroup group) {
		super();
		this.id = group.id();
		this.name = group.name();
		this.widthPercentage=group.widthPercentage();
		this.align=group.align().value;
		this.elementsPerRow=group.elementsPerRow();
		this.newRow=group.newRow();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidthPercentage() {
		return widthPercentage;
	}

	public void setWidthPercentage(int widthPercentage) {
		this.widthPercentage = widthPercentage;
	}

	public int getAlign() {
		return align;
	}

	public void setAlign(int align) {
		this.align = align;
	}

	public int getElementsPerRow() {
		return elementsPerRow;
	}

	public void setElementsPerRow(int elementsPerRow) {
		this.elementsPerRow = elementsPerRow;
	}

	public boolean isNewRow() {
		return newRow;
	}

	public void setNewRow(boolean newRow) {
		this.newRow = newRow;
	}

	public List<HtmlElementWrapper> getElements() {
		return elements;
	}

	public void setElements(List<HtmlElementWrapper> elements) {
		this.elements = elements;
	}

	public HtmlElementWrapper getElementByName(String name) {
		HtmlElementWrapper result = null;
		if (elements == null) {
			return result;
		}
		for (HtmlElementWrapper e : elements) {
			if (e.getName().equalsIgnoreCase(name)) {
				result = e;
				break;
			}
		}
		return result;
	}

	public List<String> getRules() {
		return rules;
	}

	public void setRules(List<String> rules) {
		this.rules = rules;
	}

	@JsonSetter
	public void setRules(String[] rules) {
		for(String rule:rules){
			this.rules.add(rule);
		}
	}
	
	public void addRule(String rule) {
			this.rules.add(rule);
	}

	@Override
	public String toString() {
		return "HtmlElementGroupWrapper [id=" + id + ", name=" + name + ", widthPercentage=" + widthPercentage
				+ ", elementsPerRow=" + elementsPerRow + ", newRow=" + newRow + ", elements=" + elements + ", rules="
				+ rules + "]";
	}
}
