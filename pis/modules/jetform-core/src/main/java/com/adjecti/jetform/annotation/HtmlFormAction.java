package com.adjecti.jetform.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
public @interface HtmlFormAction {
	public static final String ACTION_ADD="add";
	public static final String ACTION_EDIT="edit";
	public static final String ACTION_DELETE="delete";
	public static final String ACTION_SEARCH="search";
	public static final String ACTION_PRINT="print";
	public static final String ACTION_VIEW="view";
	public static final String ACTION_IMPORT="import";
	public static final String ACTION_EXPORT="export";
	
	public enum ControlType{
		button, link; 
	}
	
	public enum ApplyOn{
		table, row; 
	}
		
	String name();
	String label() default "default";
	String controlType() default "button";
	String action() default "default";
	String applyOn() default "table";
	String cssClass() default "";
	
	//Add criteria with {field:value} separated with semicolon(;)
	String[] criterias() default "";
	
	//Add evaluation criteria/true/false with {field:value} separated with semicolon(;)
	String[] visible() default "true";
	
	//Add evaluation criteria/true/false with {field:value} separated with semicolon(;)
	String[] enable() default "true";
	
	//Add role names as array items
	String[] accessControl() default ""; 
}
