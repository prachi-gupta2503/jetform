package com.adjecti.jetform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Relation {

	public enum RelationType{
		None, One, Many;
	}
	
	RelationType type() default RelationType.None;
	Class<?> modelClass() default Object.class;
	String valueField() default "";
	String labelField() default "";
	Class<?> mappingClass() default Object.class;
	String mappingField() default "";
	boolean lazyLoad() default true;
	String[] filter() default {};
}
