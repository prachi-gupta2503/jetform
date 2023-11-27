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
public @interface HtmlElements {
	public static final int ACCESS_TYPE_FIELD=1;
	public static final int ACCESS_TYPE_METHOD=1;
	HtmlElement[] value();
	int accessType() default ACCESS_TYPE_FIELD;
}
