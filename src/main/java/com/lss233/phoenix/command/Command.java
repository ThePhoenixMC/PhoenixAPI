package com.lss233.phoenix.command;

/**
 * .
 */
public interface Command {
    /**
     * Triggered when the command is executed with no arguments.
     * @param sender The sender of the command.
     * @param args The content of the command.
     * @return The command result.
     */
    CommandResult onRoot(CommandSender sender, CommandContent args);

    /**
     * Triggered when the command is executed unexpectedly.
     * @param sender The sender of the command.
     * @param args The content of the command.
     * @return The command result.
     */
    CommandResult onMissHandled(CommandSender sender, CommandContent args);

    /**
     * Triggered when the command executor is founded,
     * but the {@link CommandSender} has not enough permissions.
     * @param sender The sender of the command.
     * @param args The content of the command.
     * @return The command result.
     */
    default CommandResult onInsufficientPermission(CommandSender sender, CommandContent args){
        sender.sendMessage("You don't have permission to do that.");
        return CommandResult.permissionDenied();
    }
}
