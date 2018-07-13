package com.lss233.phoenix;

import com.lss233.phoenix.channel.ChannelManager;
import com.lss233.phoenix.channel.MessageListener;
import com.lss233.phoenix.command.Command;
import com.lss233.phoenix.command.CommandManager;
import com.lss233.phoenix.config.ConfigurationManager;
import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.event.EventManager;
import com.lss233.phoenix.item.enchantment.Enchantment;
import com.lss233.phoenix.item.inventory.Inventory;
import com.lss233.phoenix.item.inventory.ItemStack;
import com.lss233.phoenix.logging.Logger;
import com.lss233.phoenix.logging.ModuleLogger;
import com.lss233.phoenix.module.Module;
import com.lss233.phoenix.module.ModuleManager;
import com.lss233.phoenix.world.World;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * .
 */
public final class Phoenix {
    private static Server server;
    private static ModuleManager moduleManager;
    private static CommandManager commandManager;
    private static ConfigurationManager configurationManager;
    private static ChannelManager channelManager;
    private static EventManager eventManager;
    private final static String PHOENIX_VERSION = "1.0.0";
    private static boolean debugMode = true;

    public static Server getServer(){
        return server;
    }

    /**
     * Set Phoenix payload and initial.
     * @param server payload server.
     */
    public static void setServer(Server server){
        if(Phoenix.server != null)
            throw new UnsupportedOperationException("Server has already defined.");
        Phoenix.server = server;
        server.getLogger().info("Phoenix is running on " + server.getName()+ " version " + server.getVersion() + ".");

        // Init Phoenix
        // / Command
        commandManager = new CommandManager();
        // / Configuration
        configurationManager = new ConfigurationManager();
        // / Event
        eventManager = new EventManager();
        // / Channel
        channelManager = new ChannelManager();
        // / Module
        moduleManager =  new ModuleManager();

        getServer().getInterface().loadModules();
        moduleManager.initialModules();

        moduleManager.enableModules();
    }
    public static Logger getLogger(String name){
        return new ModuleLogger(name);
    }

    public static ModuleManager getModuleManager(){
        return moduleManager;
    }
    public static CommandManager getCommandManager() { return commandManager;}

    public static ConfigurationManager getConfigurationManager() {
        return configurationManager;
    }

    public static ChannelManager getChannelManager() {
        return channelManager;
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public static boolean getDebugMode() {
        return debugMode;
    }

    public static String getVersion() {
        return PHOENIX_VERSION;
    }

    /**
     * Server core
     */
    public interface Server{
        String getName();
        String getVersion();
        String getIp();
        String getServerName();
        String getServerId();

        int getMaxPlayers();

        @Deprecated
        int getViewDistance();

        boolean hasAllowNether();
        boolean hasWhitelist();
        boolean hasGenerateStructures();

        default Optional<World> getWorld(String worldName){
            return getWorlds().stream().filter(world -> world.getName().equalsIgnoreCase(worldName)).findFirst();
        }
        default Optional<World> getWorld(UUID uniqueId){
            return getWorlds().stream().filter(world -> world.getUniqueId().equals(uniqueId)).findFirst();
        }

        default Optional<Player> getPlayer(String playerName){
            return getOnlinePlayers().stream().filter(player -> player.getName().equalsIgnoreCase(playerName)).findFirst();
        }
        default Optional<Player> getPlayer(UUID uniqueId){
            return getOnlinePlayers().stream().filter(player -> player.getUniqueId().equals(uniqueId)).findFirst();
        }

        List<World> getWorlds();
        List<Player> getOnlinePlayers();

        File getPhoenixDataDir();
        Logger getLogger();

        Interface getInterface();

        interface Interface {
            void loadModules();

            void registerCommand(Command command);

            MessageChannelManager getMessageChannelManager();

            Inventory registerInventory(Inventory.Builder builder);

            ItemStack registerItemStack(ItemStack.Builder builder);

            Enchantment registerEnchantment(Enchantment.Builder builder);

            interface MessageChannelManager {
                void registerOutgoingPluginChannel(Module module, String channelName);

                void registerIncomingPluginChannel(Module module, String channelName, MessageListener listener);
            }
        }
    }
}
