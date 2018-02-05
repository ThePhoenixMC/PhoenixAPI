package com.lss233.phoenix.command;

import java.lang.annotation.*;

/**
 * An annotation to mark methods as being command executor methods.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CommandRouters.class)
public @interface CommandRouter {
    /**
     * The arguments of the command.
     * <p>
     *     If you don't want have any arguments,
     *     you can use {@link Command#onRoot(CommandSender, CommandContent)} method.
     * </p>
     * @return The arguments fo the command.
     */
    String args();

    /**
     * The permission of the command.
     * <p>
     * If player don't have enough permission,
     * this method will not be invoked.
     * </p>
     * @return The permission of the command.
     */
    String permission() default "";

    /**
     * The sender of the command.
     * <p>
     *     If the command sender does not
     *     match this value, this method
     *     will not be invoked.
     * </p>
     * @return The sender of the command.
     */
    Sender sender() default Sender.ALL;

    /**
         * Whether this method is the last invoked.
     * <p>
     *     True if you want stop Phoenix from invoking
     *     other {@link Command} methods if match.
     * </p>
     * @return If this method is the last invoked.
     */
    boolean last() default false;

    /**
     * The Sender of the command.
     */
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
