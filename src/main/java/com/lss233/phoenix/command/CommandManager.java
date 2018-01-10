package com.lss233.phoenix.command;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.module.Module;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.*;

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
        try {
            // Check
            if (command.getClass().getAnnotation(PhoenixCommand.class) == null) {
                throw new UnsupportedOperationException("Command must has PhoenixCommand annotation.");
            }
            commandMap.computeIfAbsent(module, k -> new ArrayList<>());
            commandMap.get(module).add(command);
            Phoenix.getServer().getInterface().registerCommand(command);
        } catch (UnsupportedOperationException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Handle command, pass the command to target module.
     *
     * @param sender Command sender
     * @param label  Command label
     * @param args   Command arguments
     * @return Whether the command was successfully handled.
     */
    public boolean handleCommand(CommandSender sender, String label, String[] args) {
        // Needs improve
        ArgumentsMap argumentsMap = new ArgumentsMap();

        Command cmd = getCommand(label);
        CommandRouter router;
        Matcher matcher;
        String vArg, oArg;

        if (cmd == null)
            return false;
        for (Method method : cmd.getClass().getMethods()) {
            try {
                router = method.getAnnotation(CommandRouter.class);

                if (router == null || method.getParameters().length != 3)
                    continue;  // Next method.
                if (!router.sender().equals(CommandRouter.Sender.ALL))
                    switch (router.sender()) {
                        case Player:
                            if (!(sender instanceof Player))
                                continue;
                            break;
                        case Block:
                            if (!(sender instanceof BlockCommandSender))
                                continue;
                        case Console:
                            if (!(sender instanceof ConsoleCommandSender))
                                continue;
                        case RemoteConsole:
                            if (!(sender instanceof RemoteConsoleCommandSender))
                                continue;
                    }

                String[] vArgs = router.args().split(" ");
                if (args.length > vArgs.length && !router.args().endsWith("...]") && !router.args().endsWith("...>"))
                    continue;
            /*
               Syntax:
               * Variable:
               * * [var] - Option
               * * <var> - Required
               * * var - Path
                */
                for (int i = 0; i < vArgs.length; i++) {
                    vArg = vArgs[i];
                    oArg = args[i];
                    if (!(vArg.matches("^\\[(.+)]$") || vArg.matches("^<(.+)>$"))) {
                        if (!vArg.equalsIgnoreCase(oArg))
                            throw new MethodNotMatchException();

                    } else {
                        matcher = vArgPattern.matcher(vArg);
                        if (matcher.find()) {
                            String key = matcher.group().substring(1, matcher.group().length() - 1);
                            if(key.endsWith("...")) { // <key...>
                                String[] dest = new String[args.length - i];
                                /*
                                System.arraycopy(args, i, dest, args.length - 1 , dest.length);
                                */
                                for (int i1 = i; i1 < args.length; i1++) {
                                    dest[i1 - i] = args[i1];
                                }
                                argumentsMap.set(key, dest);
                            } else {
                                argumentsMap.set(key, oArg);
                            }

                        }

                    }
                }
            } catch (MethodNotMatchException | ArrayIndexOutOfBoundsException ex) {
                continue;
            }
            try {
                return (Boolean) method.invoke(cmd, sender, label, argumentsMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                sender.sendMessage("An error has ");
            }
        }
        return cmd.onMissHandled(sender, label, args);
    }

}
