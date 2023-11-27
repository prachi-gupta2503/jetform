package com.adjecti.jetform.annotation.element;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.adjecti.jetform.annotation.DataProvider;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Select Annotation helps to take
 * Single or multitype select value HTML elements
 * @author  Sumant Chaubey
 * @see Text
 * @see Date
 * @see File
 * @see Hidden
 * @see Phone
 * @see Radio
 * @see Email
 * @see Password
 * @see Checkbox
 * 
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Select {
	public enum SelectType{
		SINGLE, MULTIPLE;
	}
	
	CommonAttributes commonAttributes() default @CommonAttributes();
	SelectType selectType() default SelectType.SINGLE;
	DataProvider dataProvider();
}
