/**
 * 
 */
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
@Target({ FIELD, METHOD, TYPE })

public @interface HtmlElementGroups {
	public static final String ALIGN_VERTICAL="vertical";
	public static final String ALIGN_HORIZONTAL="horizontal";
	
	HtmlElementGroup[] value() default {};
	String alignment() default ALIGN_VERTICAL; 
}
