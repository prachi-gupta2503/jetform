package com.adjecti.jetform.annotation.element;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.adjecti.jetform.annotation.DataProvider;
import com.adjecti.jetform.annotation.ListControlType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface States {
	CommonAttributes commonAttributes() default @CommonAttributes();
	ListControlType controlType() default ListControlType.SELECT;
	DataProvider dataProvider();
}
