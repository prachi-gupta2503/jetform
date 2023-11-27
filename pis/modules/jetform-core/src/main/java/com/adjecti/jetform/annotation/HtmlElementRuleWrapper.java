package com.adjecti.jetform.annotation;

import java.io.Serializable;

public class HtmlElementRuleWrapper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String key;
	String value;

	public HtmlElementRuleWrapper() {
		super();
	}
	
	public HtmlElementRuleWrapper(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public HtmlElementRuleWrapper(HtmlElementRule condition) {
		this(condition.key(), condition.value());
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
		return "HtmlElementRuleWrapper [key=" + key + ", value=" + value + "]";
	}
}
