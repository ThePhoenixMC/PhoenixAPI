package com.lss233.phoenix.builtin.commands;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.command.*;

/**
 *
 */
@PhoenixCommand(label = "phoenix", description = "Phoenix built-in commands", permission = "phoenix.admin", alias = {"p"})
public class PhoenixCommandExecutor implements Command {
    @CommandRouter(args = "help", permission = "phoenix.admin.help")
    public boolean help(CommandSender sender, String label, ArgumentsMap args) {
        sender.sendMessage("          Phoenix Framework          ");
        sender.sendMessage("-------------------------------------");
        sender.sendMessage("/phoenix help    -    Show help menu.");
        sender.sendMessage("/phoenix reload  -    Reload modules.");
        sender.sendMessage("/phoenix version -    Show Phoenix version.");
        return true;
    }
    @CommandRouter(args = "reload", permission = "phoenix.admin.reload")
    public boolean reload(CommandSender sender, String label, ArgumentsMap args) {
        return true;
    }
    @CommandRouter(args = "version", permission = "phoenix.admin.version")
    public boolean version(CommandSender sender, String label, ArgumentsMap args) {
        sender.sendMessage("Server is running on " + Phoenix.getServer().getVersion() + " with Phoenix " + Phoenix.getVersion());
        return true;
    }
    @Override
    public boolean onMissHandled(CommandSender sender, String label, String[] args) {
        return help(sender, label, null);
    }
}
