package com.adjecti.jetform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ImportExport {
	public enum Format {
		EXCEL, CSV, WORD, PDF;
	}

	boolean importable() default true;

	boolean exportable() default true;

	Format format() default Format.EXCEL;

	boolean deleteOnImport() default false;

	int startRow() default 0;

	int startCol() default 0;

	boolean header() default true;
}
