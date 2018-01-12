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
    public File getConfigurationDirectory(Module module) {
        return new File(Phoenix.getServer().getPhoenixDataDir(), "config/" + ModuleManager.getModuleInfo(module).getId());
    }

    /**
     * Gets the config.json file from the config directory of module.
     * @param module The module.
     * @return The config.json file instance.
     */
    public File getDefaultConfigurationFile(Module module) {
        return new File(getConfigurationDirectory(module), "config.json");
    }

    /**
     * Gets the default config file of the module.
     * @param module The module.
     * @return The config instance.
     * @throws IOException Failed to load config.
     */
    public JsonConfiguration getConfig(Module module) throws IOException {
        File file = getDefaultConfigurationFile(module);
        if(!file.exists())
            if(!file.createNewFile())
                throw new IOException("Failed to create file, check your disk space or something.");
        return JsonConfiguration.load(file);
    }
}
