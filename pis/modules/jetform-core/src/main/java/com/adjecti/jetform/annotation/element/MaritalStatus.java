package com.adjecti.jetform.annotation.element;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.adjecti.jetform.annotation.ListControlType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target(FIELD)
public @interface MaritalStatus {
	CommonAttributes commonAttributes() default @CommonAttributes();
	ListControlType controlType() default ListControlType.RADIO;
}
