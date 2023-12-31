package com.adjecti.jetform.model;

import java.io.Serializable;

public class KeyValue implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String key="";
	private String value="";
	
	public KeyValue() {
		super();
	}
	
	public KeyValue(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public KeyValue(Object key, String value) {
		super();
		this.key = String.valueOf(key);
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "KeyValue [key=" + key + ", value=" + value + "]";
	}
}
