package com.lss233.phoenix.module;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.logging.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * .
 */
public class ModuleManager {

    private final Collection<URL> libs = new ArrayList<>();
    private List<Module> modules = new ArrayList<>();
    private Logger logger = Phoenix.getServer().getLogger();

    /**
     * Loads a module from an exist instance.
     * @param module The module
     */
    public void loadModule(Module module) {
        modules.add(module);
    }

    /**
     * Loads a module from a file.
     * @param file The file.
     * @return The module.
     * @throws InvalidModuleException The file is not a valid module.
     * @throws IOException Failed to load the file.
     */
    public Module loadModule(File file) throws InvalidModuleException, IOException {
        if (!file.exists()) {
            throw new InvalidModuleException(new FileNotFoundException(file.getPath() + " does not exist"));
        }
        libs.add(file.toURI().toURL());
        URLClassLoader ucl = new URLClassLoader(libs.toArray(new URL[]{}), ModuleManager.class.getClassLoader());
        Module mod = null;
        JarFile modFile = new JarFile(file);
        Enumeration<JarEntry> entries = modFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String subFile = entry.getName();
            if (subFile.endsWith(".class")) {
                String classname = subFile.replace('/', '.').substring(0, subFile.length() - 6);
                try {
                    Class<?> c = Class.forName(classname, false, ucl);
                    if (c.getAnnotation(PhoenixModule.class) != null) {
                        mod = (Module) c.newInstance();
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessError | IllegalAccessException | NoClassDefFoundError e) {
                    logger.warn("Failed to instantiate " + classname + " from " + file);
                    e.printStackTrace();
                } catch (VerifyError ignored) {
                }
            }
        }
        if (mod == null) {
            logger.warn("Could not found any module from " + file);
        } else {
            modules.add(mod);
        }
        return mod;
    }

    public void getModule(String name) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    /**
     * Unloads a module from Phoenix system.
     * @param module The module.
     */
    public void unloadModule(Module module) {
        disableModule(module);
        modules.remove(module);
    }

    /**
     * Initials a module.
     * @param module The module.
     */
    public void initialModule(Module module) {
        if (!module.getState().equals(Module.State.LOADED)) {
            module.onInitial();
            module.setState(Module.State.LOADED);
        } else {
            throw new UnsupportedOperationException("Module not loaded or has already initialed!");
        }
    }

    /**
     * Enables a module.
     * @param module The module.
     */
    public void enableModule(Module module) {
        if (!module.getState().equals(Module.State.ENABLED)) {
            module.onEnable();
            module.setState(Module.State.ENABLED);
        } else {
            throw new UnsupportedOperationException("Cannot enable a module twice!");
        }
    }

    /**
     * Disables a module.
     * @param module The module.
     */
    public void disableModule(Module module) {
        if (!module.getState().equals(Module.State.DISABLED)) {
            module.onDisable();
            module.setState(Module.State.DISABLED);
        } else {
            throw new UnsupportedOperationException("Cannot disable a module twice!");
        }
    }

    public void initialModules() {
        for (Module module : modules) {
            enableModule(module);
        }
    }

    public void enableModules() {
        for (Module module : modules) {
            disableModule(module);
        }
    }

    /**
     * Gets the info of a module.
     * @param module The module.
     * @return The info.
     */
    public static ModuleInfo getModuleInfo(Module module) {
        ModuleInfo info = new ModuleInfo();
        PhoenixModule phoenixModule = module.getClass().getAnnotation(PhoenixModule.class);
        info.setId(phoenixModule.modid());
        info.setName(phoenixModule.name());
        info.setVersion(phoenixModule.version());
        return info;
    }
}