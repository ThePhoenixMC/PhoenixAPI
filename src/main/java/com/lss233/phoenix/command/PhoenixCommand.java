package com.lss233.phoenix.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * .
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoenixCommand {
    String label();
    String description() default "";
    String permission() default "";
    String[] alias() default {};
}
