package com.adjecti.jetform.annotation.element;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.adjecti.jetform.annotation.DataProvider;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Radio Annotation helps to take Single or multitype radioBox value HTML
 * elements
 * 
 * @author Sumant Chaubey
 * @see Text
 * @see Date
 * @see File
 * @see Hidden
 * @see Phone
 * @see Select
 * @see Email
 * @see Password
 * @see Checkbox
 * 
 */

@Retention(RUNTIME)
@Target(FIELD)
public @interface Radio {
	DataProvider dataProvider();

	CommonAttributes commonAttributes() default @CommonAttributes();

}
