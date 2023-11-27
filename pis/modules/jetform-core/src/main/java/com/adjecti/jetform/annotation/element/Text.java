package com.adjecti.jetform.annotation.element;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Text Annotation helps to genrate
 * Text type input field elements in Html
 *
 * @author Sumant Chaubey
 * @see Email
 * @see Date
 * @see Hidden
 * @see Number
 * @see Phone
 * @see Select
 * @see File
 * @see Password
 * @see Checkbox
 * @see Radio
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Text {
	CommonAttributes commonAttributes() default @CommonAttributes();
	boolean hidden() default false;
	boolean i18n() default false;
}
