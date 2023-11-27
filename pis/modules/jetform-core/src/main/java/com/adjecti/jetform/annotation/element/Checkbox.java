package com.adjecti.jetform.annotation.element;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.adjecti.jetform.annotation.DataProvider;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * Checkbox Annotation helps to genrate
 * ckeckbox type input field elements in Html
 *
 * @author Sumant Chaubey
 * @see Text
 * @see Date
 * @see File
 * @see Hidden
 * @see Select
 * @see Radio
 * @see Email
 * @see Password
 * @see Phone
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Checkbox {
	enum Type{
		CHECKBOX, TOGGLE;
	}
	
	DataProvider dataProvider();
	CommonAttributes commonAttributes() default @CommonAttributes();
	Type type() default Type.CHECKBOX;
}
