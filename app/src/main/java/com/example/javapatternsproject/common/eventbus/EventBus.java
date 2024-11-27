package com.example.javapatternsproject.common.eventbus;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Задание 21 Observer.
 * @return
 */
public class EventBus {
    private final ConcurrentHashMap<Class<?>, List<EventListener<?>>> listeners = new ConcurrentHashMap<>();

    // Регистрация слушателя
    public <T> void register(Class<T> eventType, EventListener<T> listener) {
        listeners.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>()).add(listener);
    }

    // Удаление слушателя
    public <T> void unregister(Class<T> eventType, EventListener<T> listener) {
        List<EventListener<?>> eventListeners = listeners.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void post(T event) {
        List<EventListener<?>> eventListeners = listeners.get(event.getClass());
        if (eventListeners != null) {
            for (EventListener<?> listener : eventListeners) {
                try {
                    ((EventListener<T>) listener).onEvent(event);
                } catch (Exception e) {
                    //ignore
                }
            }
        }
    }
}
