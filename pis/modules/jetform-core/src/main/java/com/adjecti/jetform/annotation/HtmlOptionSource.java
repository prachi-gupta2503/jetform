package com.adjecti.jetform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface HtmlOptionSource{
	public enum SourceType{
		csv, array, serviceUtil, restApi;
	}
}
