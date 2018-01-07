package com.lss233.phoenix.command;

/**
 * .
 */
public interface Command {
    boolean onMissHandled(CommandSender sender, String label, String[] args);
}
