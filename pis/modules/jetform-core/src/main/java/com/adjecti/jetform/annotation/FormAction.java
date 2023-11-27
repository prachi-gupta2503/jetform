package com.adjecti.jetform.annotation;



import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.adjecti.jetform.annotation.Action;
import com.adjecti.jetform.annotation.CTAType;
import com.adjecti.jetform.annotation.FormActionType;

@Retention(RUNTIME)
@Target(FIELD)
public @interface FormAction {
     String url() ;
     Action action()  default Action.CREATE;
     FormActionType type() default FormActionType.CRUD;
     CTAType ctaType() default CTAType.BUTTON;
     String buttonOrLinkValue() default "";
     boolean listable() default false;
}
