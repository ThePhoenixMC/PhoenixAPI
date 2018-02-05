package com.lss233.phoenix.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to mark methods as being command executor methods.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CommandRouters{
    CommandRouter[] value();
}
