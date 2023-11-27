package com.adjecti.jetform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface HtmlElement {
	
	public static final String REGEXP_BLOODGROUP="/^(A|B|AB|O)[+-]$/i";
	public static final String REGEXP_NAME="/^[A-Za-z0-9_().\\- ]+$/";
	public static final String REGEXP_ALPHA_SPACE="/^[A-Za-z ]+$/";
	public static final String REGEXP_ALPHA_WITHALLSYMBOL = "/^[a-zA-Z ,._&+%-/$]+$/";/* "/^[A-Za-z ,.&-+]+$/"; */
	public static final String REGEXP_ALPHANUM_SPACE="/^[A-Za-z0-9 ]+$/";
	public static final String REGEXP_PANNO="/([A-Z]){5}([0-9]){4}([A-Z]){1}$/";
	
	public enum ControlType{
		text, password, hidden, textarea, radio, checkbox, select, date, datetime, email, multiSelect, list, phone, number, fileUpload,fileDragDrop, fileBrowser, fileScan, fileUploadBrowseScan, fileUploadBrowseScanView, form, country, bloodGroup, weekDay, monthDay, month, year, monthYear, currentMonth, currentYear,currentMonthYear, gender, maritalStatus, textEditor, custom, paragraph, page;
	}
	
	public enum ValidType{
		none, email, phone, zip, number, date, datetime, alpha, alphanum, digits; 
	}
	
//	public enum RelationType{
//		None, One, Many;
//	}
	
	public enum Alignment{
		horizontal, vertical;
	}
	
	String name() default "";
	String attribute () default "";
	boolean key() default false;
	String label() default "";
	boolean exclude() default false;
	String depends() default "";
	String dependantKey() default "";
	String placeHolder() default "";
	String format() default "";
	String listField() default "";
	boolean seachable() default false;
	boolean unique() default false;
	boolean listable() default true;
	boolean required() default false;
	boolean readOnly() default false;
	int max() default 0;
	int min() default 0;
	int maxLength() default 0;
	int minLength() default 0;
	String regExp() default "";
	String displayWidth() default "";
	Relation relation() default @Relation();
	ControlType controlType() default ControlType.text;
	ValidType validType() default ValidType.none;
	
	String dataQuery() default "";
	String[] options() default {};
	int group() default 0;
	String[] rules() default {};
	String formDefinition() default "";
	boolean transientElement() default false;
	boolean tab() default false;
	String tabTitle() default "";
	int elementsPerColumn() default 0;
	Alignment tableRowAlign() default Alignment.horizontal;
	HtmlEvent[] events() default {};
	Class formClass() default Object.class;
	String mappingField() default "";
	String value() default "";
	
	boolean formFlowKey() default false;
	String customTemplate() default "";
	
	
	int cols() default 0;
	int rows() default 0;
	//boolean formFlowProcess() default false;
	
	//Used for document fileUpload components
	//Folder can take default parameters "/" as path or "0" as folderId
	String folder() default "0";
	boolean folderAutoCreate() default false;
	String accept() default "";
	//preview () is for images
	boolean preview() default false;
	boolean thumbnail() default false;
	int width() default 0;
	int height() default 0;
	long fileSize() default 0;
	
	boolean link() default false; 
	String linkAction() default "";
	
	String matchWith() default "";
	String matchValue() default "0";
	String matchType() default "equals";
	String matchUnit() default "0";
	
	String dateBefore() default "";
	String dateAfter() default "";
	
	/*int yearBefore() default 0;
	int yearAfter() default 0;
	int monthBefore() default 0;
	int monthAfter() default 0;
	int dayBefore() default 0;
	int dayAfter() default 0;*/
	
	String yearBefore() default "";
	String yearAfter() default "";
	String monthBefore() default "";
	String monthAfter() default "";
	String dayBefore() default "";
	String dayAfter() default "";
	
	/*int yearLess() default 0;
	int yearMore() default 0;
	int monthLess() default 0;
	int monthMore() default 0;
	int dayLess() default 0;
	int dayMore() default 0;*/
	
	/* updated by Prachi gupta on 24 june 2022 */ 
	boolean tooltip() default false;
	String helpText() default "";
}
