package com.lss233.phoenix.config;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.config.json.JsonConfiguration;
import com.lss233.phoenix.module.Module;
import com.lss233.phoenix.module.ModuleManager;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class ConfigurationManager {
    public ConfigurationManager() {
        if (Phoenix.getConfigurationManager() != null)
            throw new UnsupportedOperationException("ConfigurationManager already defined.");
    }

    /**
     * Gets the config directory of module.
     * @param module The module.
     * @return The directory.
     */
    public static File getConfigurationDirectory(Module module) {
        return new File(Phoenix.getServer().getPhoenixDataDir(), "config/" + ModuleManager.getModuleInfo(module).getId());
    }

    /**
     * Gets the config.json file from the config directory of module.
     * @param module The module.
     * @return The config.json file instance.
     */
    public static File getDefaultConfigurationFile(Module module) {
        return new File(getConfigurationDirectory(module), "config.json");
    }

    public static JsonConfiguration getConfig(Module module) throws IOException {
        return JsonConfiguration.load(getDefaultConfigurationFile(module));
    }
}
