package com.lss233.phoenix.command;

/**
 * .
 */
public interface Command {
    /**
     * Triggered when the command is executed with no arguments.
     * @param sender The sender of the command.
     * @param args The content of the command.
     * @return If the command is proceed correctly.
     */
    boolean onRoot(CommandSender sender,CommandContent args);

    /**
     * Triggered when the command is executed unexpectedly.
     * @param sender The sender of the command.
     * @param args The content of the command.
     * @return If the command is proceed correctly.
     */
    boolean onMissHandled(CommandSender sender,CommandContent args);
}
