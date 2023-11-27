package com.adjecti.jetform.annotation.element;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface RangeSlider {
	
	CommonAttributes commonAttributes() default @CommonAttributes();

	int min() default 0;
	int max() default 100;
}
