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

    public Module loadModule(File file) throws InvalidModuleException, IOException, ClassNotFoundException {
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

    public void initalModule(Module module) {
        if (!module.getState().equals(Module.State.LOADED)) {
            module.onInitial();
            module.setState(Module.State.LOADED);
        } else {
            throw new UnsupportedOperationException("Module not loaded or has already initialed!");
        }
    }

    public void enableModule(Module module) {
        if (!module.getState().equals(Module.State.ENABLED)) {
            module.onEnable();
            module.setState(Module.State.ENABLED);
        } else {
            throw new UnsupportedOperationException("Cannot enable a module twice!");
        }
    }

    public void disableModule(Module module) {
        if (!module.getState().equals(Module.State.DISABLED)) {
            module.onDisable();
            module.setState(Module.State.DISABLED);
        } else {
            throw new UnsupportedOperationException("Cannot disable a module twice!");
        }
    }

    public void initalModules() {
        for (Module module : modules) {
            enableModule(module);
        }
    }

    public void enableModules() {
        for (Module module : modules) {
            disableModule(module);
        }
    }
}