package com.adjecti.jetform.annotation.element;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * File Annotation helps to genrate
 * File type input field elements in Html
 * @author  Sumant Chaubey
 * @see Text
 * @see Date
 * @see Hidden
 * @see Number
 * @see Phone
 * @see Select
 * @see Email
 * @see Password
 * @see Checkbox
 * @see Radio
 * 
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface File {
	boolean autoUpload () default false;
	boolean dragDrop () default false;
}
