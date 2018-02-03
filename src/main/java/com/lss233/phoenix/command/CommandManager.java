package com.lss233.phoenix.command;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.module.Module;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * .
 */
public class CommandManager {
    private final Pattern vArgPattern = Pattern.compile("^[\\[,<](.+)[>,\\]]$");
    private Map<Module, List<Command>> commandMap = new HashMap<>();

    public CommandManager() {
        if (Phoenix.getCommandManager() != null)
            throw new UnsupportedOperationException("CommandManager already defined.");
    }

    /**
     * Get a Command instance by label.
     *
     * @param label Command label
     * @return Command instance
     */
    public Command getCommand(String label) {
        if (label.contains(":")) {
            //noinspection SuspiciousMethodCalls
            List<Command> commands = commandMap.get(label.split(":", 2)[0]);
            if (commands != null)
                for (Command command : commands) {
                    if (command.getClass().getAnnotation(PhoenixCommand.class).label().equalsIgnoreCase(label))
                        return command;
                    else
                        for (String alias :
                                command.getClass().getAnnotation(PhoenixCommand.class).alias()) {
                            if (alias.equalsIgnoreCase(label))
                                return command;
                        }
                }
        }
        for (List<Command> commands : commandMap.values()) {
            for (Command command : commands) {
                if (command.getClass().getAnnotation(PhoenixCommand.class).label().equalsIgnoreCase(label))
                    return command;
                else
                    for (String alias :
                            command.getClass().getAnnotation(PhoenixCommand.class).alias()) {
                        if (alias.equalsIgnoreCase(label))
                            return command;
                    }
            }
        }
        return null;
    }

    /**
     * Register a new Command instance.
     *
     * @param command Command instance
     * @param module  Register's module
     */
    public void registerCommand(Module module, Command command) {
        if (command.getClass().getAnnotation(PhoenixCommand.class) == null) {
            throw new UnsupportedOperationException("Command must has PhoenixCommand annotation.");
        }
        commandMap.computeIfAbsent(module, k -> new ArrayList<>());
        commandMap.get(module).add(command);
        Phoenix.getServer().getInterface().registerCommand(command);
    }

    /**
     * Unregister a command.
     *
     * @param module  The module of the command.
     * @param command The command instance.
     */
    public void unregisterCommand(Module module, Command command) {
        if (command.getClass().getAnnotation(PhoenixCommand.class) == null) {
            throw new UnsupportedOperationException("Command must has PhoenixCommand annotation.");
        }
        if (commandMap.containsKey(module)) {
            commandMap.get(module).remove(command);
        }
    }

    /**
     * Unregister all commands of a module.
     *
     * @param module The module.
     */
    public void unregisterCommands(Module module) {
        if (commandMap.containsKey(module)) {
            commandMap.remove(module);
        }
    }

    private boolean validCommandArgumentsLength(CommandRouter router, String[] args) {
        String[] vArgs = router.args().split(" ");
        return !(args.length > vArgs.length && !router.args().endsWith("...]") && !router.args().endsWith("...>"));

    }

    private boolean validCommandSender(CommandRouter router, CommandSender sender) {
        if (!router.sender().equals(CommandRouter.Sender.ALL))
            switch (router.sender()) {
                case Player:
                    if (!(sender instanceof Player))
                        return false;
                    break;
                case Block:
                    if (!(sender instanceof BlockCommandSender))
                        return false;
                case Console:
                    if (!(sender instanceof ConsoleCommandSender))
                        return false;
                case RemoteConsole:
                    if (!(sender instanceof RemoteConsoleCommandSender))
                        return false;
                    break;
            }
        return true;
    }

    /**
     * Handle command, pass the command to target module.
     *
     * @param sender Command sender
     * @param label  Command label
     * @param args   Command arguments
     * @return Whether the command was successfully handled.
     */
    public CommandResult handleCommand(CommandSender sender, String label, String[] args) {
        // Needs improve
        CommandContent commandContent = new CommandContent();
        commandContent.setLabel(label);

        Command cmd = getCommand(label);
        CommandResult.Builder commandResult = CommandResult.builder();
        CommandRouter[] routers;
        Matcher matcher;
        String[] vArgs;
        String vArg, oArg;

        if (cmd == null)
            return CommandResult.notFound();
        if (args.length == 0)
            return cmd.onRoot(sender, commandContent);
        for (Method method : cmd.getClass().getMethods()) {
            routers = method.getDeclaredAnnotationsByType(CommandRouter.class);
            if (routers.length == 0 || method.getParameters().length != 2)
                continue;  // Next method.
            for (CommandRouter router : routers) {
                try {
                    commandContent.clearContent();
                    if (!(
                            validCommandSender(router, sender) &&
                                    validCommandArgumentsLength(router, args) &&
                                    validCommandPath(router, args)
                    ))
                        continue;
                /*
                   Syntax:
                   * Variable:
                   * * [var] - Option
                   * * <var> - Required
                   * * var - Path
                    */
                    vArgs = router.args().split(" ");
                    for (int i = 0; i < vArgs.length; i++) {
                        vArg = vArgs[i];
                        oArg = args[i];
                        if (vArg.matches("^\\[(.+)]$") || vArg.matches("^<(.+)>$")) {
                            matcher = vArgPattern.matcher(vArg);
                            if (matcher.find()) {
                                String key = matcher.group().substring(1, matcher.group().length() - 1);
                                if (key.endsWith("...")) { // <key...>
                                    String[] dest = new String[args.length - i];
                                    System.arraycopy(args, i, dest, 0, args.length - i);
                                    commandContent.set(key, dest);
                                } else {
                                    commandContent.set(key, oArg);
                                }

                            }

                        }
                    }
                    commandResult.append((CommandResult) method.invoke(cmd, sender, commandContent));
                    if (router.last())
                        return commandResult.build();
                } catch (ArrayIndexOutOfBoundsException ignored) {
                } catch (IllegalAccessException | InvocationTargetException e) {
                    sender.sendMessage("Failed to execute this command.");
                    e.printStackTrace();
                }
            }
        }
        if (commandResult.getInvokedExecutors() <= 0)
            return cmd.onMissHandled(sender, commandContent);
        else
            return commandResult.build();
    }

    private boolean validCommandPath(CommandRouter router, String[] args) {
        String[] vArgs = router.args().split(" ");
        for (int i = 0; i < vArgs.length; i++) {
            if (vArgs[i].matches("^\\[(.+)]$") || vArgs[i].matches("^<(.+)>$"))
                continue;
            if (!vArgs[i].equalsIgnoreCase(args[i]))
                return false;
        }
        return true;
    }

}
