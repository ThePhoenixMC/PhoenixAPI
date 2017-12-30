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

    public void registerEventListener(EventListener listener, Module module) {
        listenerMap.computeIfAbsent(module, k -> new ArrayList<>());
        listenerMap.get(module).add(listener);
    }

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
