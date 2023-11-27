package com.adjecti.jetform.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface HtmlElementRuleGroups {
	public static final String EFFECT_HIDE="hide";
	public static final String EFFECT_READONLY="readonly";
	public static final String EFFECT_UNSAVE="unsave";
	
	HtmlElementRuleGroup[] value();
}