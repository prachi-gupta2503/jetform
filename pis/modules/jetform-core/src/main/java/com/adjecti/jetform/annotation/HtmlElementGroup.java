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
public @interface HtmlElementGroup {
	enum Align{
		left(1), right(2);
		int value; 
		Align(int value) {
			this.value = value; 
		}
	};
	
	String id();
	String name() default "";
	int widthPercentage() default 100;
	Align align() default Align.left;
	int elementsPerRow() default 1;
	boolean newRow() default true;
	HtmlElement[] elements() default {};
	String[] rules() default {};
}
