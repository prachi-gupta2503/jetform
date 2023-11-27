package com.adjecti.jetform.list.model;

import java.io.Serializable;

public class RowFormat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String cssClass;
	private String cssStyle;
	private String expr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

}
