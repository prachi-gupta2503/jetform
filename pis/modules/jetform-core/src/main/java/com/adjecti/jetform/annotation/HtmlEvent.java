package com.adjecti.jetform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface HtmlEvent {
	
	public enum EventName{
		none, keydown, keyup, change; 
	}
	public enum ModelType{
		none, producer, receiver;
	}
	
	EventName name() default EventName.none;
	ModelType type() default ModelType.none;
	String[] producer() default "";
	String[] receiver() default "";
	String[] action() default "";
}
