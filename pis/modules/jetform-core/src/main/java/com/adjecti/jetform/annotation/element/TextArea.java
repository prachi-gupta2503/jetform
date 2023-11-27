package com.adjecti.jetform.annotation.element;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface TextArea {
	CommonAttributes commonAttributes() default @CommonAttributes();
    int rows() default 5;
    int cols() default 50;
}
