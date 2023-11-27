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
public @interface HtmlElementRuleGroup {
	public static final String EFFECT_HIDE="hide";
	public static final String EFFECT_READONLY="readonly";
	public static final String EFFECT_UNSAVE="unsave";
	public static final String SCOPE_PRIVATE="private";
	public static final String SCOPE_PUBLIC="public";
	
	
	String name() default "";
	HtmlElementRule[] value();
	String effect();
	String scope() default SCOPE_PUBLIC;
}
