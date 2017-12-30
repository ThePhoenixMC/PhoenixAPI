package com.lss233.phoenix.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * .
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandRouter {
    String args() default "";

    String permission() default "";

    Sender sender() default Sender.ALL;

    enum Sender {
        /**
         *  Accept all kinds of sender.
         */
        ALL,
        /**
         * Accept console sender only.
         */
        Console,
        /**
         * Accept remote console sender only.
         */
        RemoteConsole,
        /**
         * Accept block sender only.
         */
        Block,
        /**
         * Accept player sender only.
         */
        Player
    }
}
