package com.adjecti.jetform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface HtmlForm {
	public static final String ENC_TYPE_APPLICATION="application/x-www-form-urlencoded";
	public static final String ENC_TYPE_TEXT_PLAIN="text/plain";
	public static final String ENC_TYPE_MULTIPART="multipart/form-data";
	
	public static final String ACCESS_TYPE_FIELD="field";
	public static final String ACCESS_TYPE_PROPERTY="property";
	
	public static final String TAB_LAYOUT_HORIZONTAL="horizontal";
	public static final String TAB_LAYOUT_VERTICAL="vertical";
	public enum FormType{
		basic, multistep, tabs; 
	}
	
	String formId() default "";
	//String templateKey() default "";
	String accessType() default ACCESS_TYPE_FIELD;
	boolean enabled() default true;
	boolean autoLabelElements() default true;
	int columns() default 1;
	String title() default "";
	boolean caption() default true;
	boolean advanceFilter() default false;
 	String listOrder() default "";
	String encType() default ENC_TYPE_APPLICATION;
	
	HtmlElement[] elements() default {};
	
	HtmlFormAction[] actions() default {@HtmlFormAction(name=HtmlFormAction.ACTION_ADD), @HtmlFormAction(name=HtmlFormAction.ACTION_EDIT), @HtmlFormAction(name=HtmlFormAction.ACTION_DELETE)};
	HtmlElementGroup[] groups() default {};
	String groupAlignment() default HtmlElementGroups.ALIGN_VERTICAL;
	HtmlFormFlows flowFlows() default @HtmlFormFlows();
	String[] tabTitles() default {};
	int elementsPerRow() default 1;
	FormType formType() default FormType.basic;
	String tabLayout() default TAB_LAYOUT_HORIZONTAL;
	Class entityClass() default Object.class;
	boolean associationEntity() default false;
	String associationOneKey() default "";
	String associationManyKey() default "";
	String template() default "";
	String elementNamespace() default "";
	boolean selectable() default false;
	boolean formFlow() default false;
	boolean formFlowProcess() default false;
	String[] filter() default {};
	boolean crud() default true;
	boolean readOnly() default false;
}
