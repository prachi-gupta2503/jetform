package com.adjecti.jetform.list.model;

import java.io.Serializable;

public class StyleDef implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String format;
	private String align;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}
}
