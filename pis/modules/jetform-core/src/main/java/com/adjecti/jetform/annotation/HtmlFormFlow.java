package com.adjecti.jetform.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD})
public @interface HtmlFormFlow {
	public static final String KEY_TYPE_ATTRIBUTE="attribute";
	public static final String KEY_TYPE_PARAM="paramater";
	
	String key() default "";
	String[] values() default {};
	String type() default "";
	
	HtmlElementRuleGroup[] ruleGroups() default {};

}
