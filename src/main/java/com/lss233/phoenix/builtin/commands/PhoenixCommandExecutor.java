package com.lss233.phoenix.builtin.commands;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.command.*;

/**
 *
 */
@PhoenixCommand(label = "phoenix", description = "Phoenix built-in commands", permission = "phoenix.admin", alias = {"p"})
public class PhoenixCommandExecutor implements Command {
    @CommandRouter(args = "reload", permission = "phoenix.admin.reload")
    public boolean reload(CommandSender sender, String label, CommandContent args) {
        return true;
    }
    @CommandRouter(args = "version", permission = "phoenix.admin.version")
    public boolean version(CommandSender sender, String label, CommandContent args) {
        sender.sendMessage("Server is running on " + Phoenix.getServer().getVersion() + " with Phoenix " + Phoenix.getVersion());
        return true;
    }

    /**
     * Triggered when the command is executed with no arguments.
     *
     * @param sender The sender of the command.
     * @param args   The content of the command.
     * @return If the command is proceed correctly.
     */
    @Override
    @CommandRouter(args = "help", permission = "phoenix.admin.help")
    public boolean onRoot(CommandSender sender, CommandContent args) {
        sender.sendMessage("          Phoenix Framework          ");
        sender.sendMessage("-------------------------------------");
        sender.sendMessage("/phoenix help    -    Show help menu.");
        sender.sendMessage("/phoenix reload  -    Reload modules.");
        sender.sendMessage("/phoenix version -    Show Phoenix version.");
        return true;
    }

    /**
     * Triggered when the command is executed unexpectedly.
     *
     * @param sender The sender of the command.
     * @param args   The content of the command.
     * @return If the command is proceed correctly.
     */
    @Override
    public boolean onMissHandled(CommandSender sender, CommandContent args) {
        return onRoot(sender, args);
    }
}
