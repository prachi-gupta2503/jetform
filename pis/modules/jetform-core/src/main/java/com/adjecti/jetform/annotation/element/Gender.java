package com.adjecti.jetform.annotation.element;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Gender {
	enum Type{
		MALE, FEMALE, TRANSGENDER;
	}
	CommonAttributes commonAttributes() default @CommonAttributes();
	Type[] types() default {Type.MALE, Type.FEMALE, Type.TRANSGENDER};
}
