package com.adjecti.jetform.annotation;

import java.io.Serializable;

public class HtmlFormFlowWrapper implements Serializable {
	private static final long serialVersionUID = 1L;

	private String key;
	private String[] values;
	
	public HtmlFormFlowWrapper() {
		super();
	}
	public HtmlFormFlowWrapper(String key, String[] values) {
		super();
		this.key = key;
		this.values = values;
	}
	
	public HtmlFormFlowWrapper(HtmlFormFlow flow) {
		this(flow.key(), flow.values());
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
}
