package com.lss233.phoenix.event;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.module.Module;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 */
public class EventManager {
    private Map<Module, List<EventListener>> listenerMap = new HashMap<>();

    public EventManager() {
        if (Phoenix.getEventManager() != null)
            throw new UnsupportedOperationException("EventManager already defined.");
    }

    /**
     * Registers a event listener
     * @param module The module of the listener.
     * @param listener The listener instance.
     */
    public void registerListener(Module module, EventListener listener) {
        listenerMap.computeIfAbsent(module, k -> new ArrayList<>());
        listenerMap.get(module).add(listener);
    }

    /**
     * Unregisters a event listener.
     * @param module The module of the ;istener.
     * @param listener The listener instance.
     */
    public void unregisterListener(Module module, EventListener listener) {
        if(listenerMap.containsKey(module)) {
            listenerMap.get(module).remove(listener);
        }
    }

    /**
     * Unregister all listeners of a module.
     * @param module The module.
     */
    public void unregisterListeners(Module module) {
        if(listenerMap.containsKey(module)) {
            listenerMap.remove(module);
        }
    }

    /**
     * Fire a event.
     * @param event The instance of the event.
     */
    public void fire(Event event) {
        for (List<EventListener> eventListeners : listenerMap.values()) {
            eventListeners.forEach((listener -> {
                for (Method method : listener.getClass().getMethods()) {
                    if (method.getAnnotation(EventHandler.class) == null)
                        continue;
                    Class<?>[] params = method.getParameterTypes();
                    if (params[0].isInstance(event)) {
                        try {
                            method.invoke(listener, event);
                        } catch (Exception e) {
                            Phoenix.getLogger("Event").warn("Failed to pass event to " + listener.getClass().getName() + ":" + method.getName());
                            e.printStackTrace();
                        }
                    }
                }
            }));
        }
    }


}
