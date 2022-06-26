package edu.java.deipss.base.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@interface Season {

    String[] value() default {"Spring"};

}