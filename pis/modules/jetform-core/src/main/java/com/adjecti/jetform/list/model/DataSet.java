package com.adjecti.jetform.list.model;

import java.io.Serializable;

public class DataSet implements Serializable{

	private static final long serialVersionUID = 1L;

	private String type;
	private String value;
	private boolean named;

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getValue() {

		return value;
	}

	public void setValue(String value) {

		this.value = value;
	}

	public boolean isNamed() {
		return named;
	}

	public void setNamed(boolean named) {
		this.named = named;
	}

}
