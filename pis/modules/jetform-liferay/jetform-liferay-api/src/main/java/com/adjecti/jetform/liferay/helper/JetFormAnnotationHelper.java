package com.adjecti.jetform.liferay.helper;

public interface JetFormAnnotationHelper {
	/*
	 * HtmlFormWrapper getHtmlFormByClass(String className) throws
	 * ClassNotFoundException;
	 * 
	 * HtmlFormWrapper getHtmlFormByClass(Class<?> formClass) throws
	 * ClassNotFoundException;
	 * 
	 * List<KeyValue> getListOptions(Class entityClass, Map<String, String> filter,
	 * String valueField, String labelField);
	 * 
	 * 
	 * HtmlFormWrapper getHtmlForm(Class<?> clazz) throws ClassNotFoundException;
	 * 
	 * HtmlFormWrapper getHtmlForm(String className);
	 * 
	 */
	void generateForm(String className) throws ClassNotFoundException;

	
	
}
