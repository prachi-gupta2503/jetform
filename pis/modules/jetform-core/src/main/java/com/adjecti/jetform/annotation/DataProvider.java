package com.adjecti.jetform.annotation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface DataProvider {
	
	String resource() default "";
	ResourceType resourceType();
	LoadType loadType() default LoadType.EAGER;
}
