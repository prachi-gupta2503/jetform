package com.adjecti.jetform.annotation;

import java.io.Serializable;

public class HtmlEventWrapper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String name;
	String[] producer;	
	String[] receiver;
	String[] action;
	String[] paramName;
	
	public HtmlEventWrapper() {
	}
	
	public HtmlEventWrapper(HtmlEvent event) {
		this.name=event.name().name();
		this.producer=event.producer();
		this.receiver=event.receiver();
		this.action=event.action();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String[] getProducer() {
		return producer;
	}

	public void setProducer(String[] producer) {
		this.producer = producer;
	}

	public String[] getReceiver() {
		return receiver;
	}

	public void setReceiver(String[] receiver) {
		this.receiver = receiver;
	}

	public String[] getAction() {
		return action;
	}

	public void setAction(String[] action) {
		this.action = action;
	}

	public String[] getParamName() {
		return paramName;
	}

	public void setParamName(String[] paramName) {
		this.paramName = paramName;
	}
}
